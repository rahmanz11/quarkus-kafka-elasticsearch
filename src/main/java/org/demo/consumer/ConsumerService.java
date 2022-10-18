package org.demo.consumer;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.demo.elasticsearch.ElasticsearchService;
import org.demo.model.child.Child;
import org.demo.model.parent.Parent;
import org.demo.model.update.Update;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.jboss.logging.Logger;

import io.smallrye.reactive.messaging.annotations.Blocking;
import io.vertx.core.json.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApplicationScoped
public class ConsumerService {

    Logger log = Logger.getLogger(ConsumerService.class, "kpalmab");
    
    @Inject
    ElasticsearchService es;
    
    final String idxParent = "parent";
    final String idxChild = "child";
    
    /**
     * Consume Parent data from redpanda
     * @param data Parent data
     * @throws IOException
     */
    @Incoming("parent-in")
    @Blocking
    public CompletionStage<Void> receiveParentData(Message<Parent> data) throws IOException {
        IndexRequest request = new IndexRequest(idxParent);
        request.id(data.getPayload().getId());
        request.source(JsonObject.mapFrom(data.getPayload()).toString(), XContentType.JSON);
    
        try {
            es.index(request, idxParent);
        } catch (Exception e) {
            return data.nack(e);
        }

        return data.ack();
    }

    /**
     * Consume Child data from redpanda
     * @param data Child data
     * @throws IOException
     */
    @Incoming("child-in")
    @Blocking
    public CompletionStage<Void> receiveChildData(Message<Child> message) throws IOException {

        Child data = message.getPayload();
        List<Parent> parents = es.searchParent("kogitoprocinstanceid", data.getKogitoprocinstanceid());
        // Check if parent exists
        if (parents != null && parents.size() > 0) {
            IndexRequest request = new IndexRequest(idxChild); 
            request.id(data.getId());
            request.source(JsonObject.mapFrom(data).toString(), XContentType.JSON); 
            
            try {
                es.index(request, idxChild);
            } catch (Exception e) {
                return message.nack(e);
            }
            return message.ack();
        } 
    
        return message.nack(new Throwable("Child insert aborted! Parent missing"));
    }
    
    /**
     * Consume Update data from redpanda
     * @param data Update data
     * @throws IOException
     */
    @Incoming("update-in")
    @Blocking
    public CompletionStage<Void> receiveUpdateData(Message<Update> message) throws IOException {
        
        Update data = message.getPayload();
        List<Parent> parents = es.searchParent("kogitoprocinstanceid", data.getKogitoprocinstanceid());
        if (parents != null && parents.size() > 0) {
            parents.stream().forEachOrdered(d -> {
                IndexRequest request = new IndexRequest(idxParent);
                request.id(d.getId());
                
                // Do this to handle different types of value of VariableValue
                if (data.getData().getVariableValue().getLastName() != null) {
                    d.getData().getVariables().setTraveller(data.getData().getVariableValue());
                } else {
                    d.getData().getVariables().getTraveller().setText(data.getData().getVariableValue().getFirstName());
                    d.getData().getVariables().getTraveller().setFirstName(data.getData().getVariableValue().getText());
                    d.getData().getVariables().getTraveller().setLastName(data.getData().getVariableValue().getLastName());
                    d.getData().getVariables().getTraveller().setNationality(data.getData().getVariableValue().getNationality());
                    d.getData().getVariables().getTraveller().setEmail(data.getData().getVariableValue().getEmail());
                    d.getData().getVariables().getTraveller().getAddress().setCity(data.getData().getVariableValue().getAddress().getCity());
                    d.getData().getVariables().getTraveller().getAddress().setCountry(data.getData().getVariableValue().getAddress().getCountry());
                    d.getData().getVariables().getTraveller().getAddress().setStreet(data.getData().getVariableValue().getAddress().getStreet());
                    d.getData().getVariables().getTraveller().getAddress().setZipCode(data.getData().getVariableValue().getAddress().getZipCode());
                }
                request.source(JsonObject.mapFrom(d).toString(), XContentType.JSON);

                try {
                    es.index(request, idxParent);
                } catch (IOException e) {
                    return;
                }
            });

            return message.ack();
        }
        
        return message.nack(new Throwable("Update aborted! Parent missing"));
    }

}
