package org.demo.consumer;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.demo.elasticsearch.ElasticsearchService;
import org.demo.model.child.Child;
import org.demo.model.parent.Parent;
import org.demo.model.update.Update;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.eclipse.microprofile.reactive.messaging.OnOverflow;
import org.eclipse.microprofile.reactive.messaging.OnOverflow.Strategy;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.jboss.logging.Logger;

import io.smallrye.reactive.messaging.annotations.Blocking;
import io.smallrye.reactive.messaging.kafka.Record;
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
    @Channel("child-out")
    @OnOverflow(value = Strategy.UNBOUNDED_BUFFER)
    Emitter<Record<String, Child>> childEmitter;

    @Inject
    @Channel("update-out")
    @OnOverflow(value = Strategy.UNBOUNDED_BUFFER)
    Emitter<Record<String, Update>> updateEmitter;

    @Inject
    @Channel("parent-out")
    @OnOverflow(value = Strategy.UNBOUNDED_BUFFER)
    Emitter<Record<String, Parent>> parentEmitter;
    
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
        boolean resend = false;
        try {
            es.index(request, idxParent);
        } catch (Exception e) {
            resend = true;
            log.errorf("exception in parent index '%s'", e.getMessage());
        }

        if (resend) {
            resendParent(data.getPayload());
        }

        return data.ack();
    }

    private void resendParent(Parent data) {
        try {
            parentEmitter.send(Record.of(data.getId(), data))
            .whenComplete((success, failure) -> {
                if (failure != null) {
                    log.errorf("Failed to publish parent data in resend '%s'", failure.getMessage());
                }
            });
        } catch (Exception e) {
            log.errorf("Exception in publish parent data in resend '%s'", e.getMessage());
        }
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
        boolean resend = false;
        if (parents != null && parents.size() > 0) {
            IndexRequest request = new IndexRequest(idxChild); 
            request.id(data.getId());
            request.source(JsonObject.mapFrom(data).toString(), XContentType.JSON); 
            
            try {
                es.index(request, idxChild);
            } catch (Exception e) {
                log.errorf("exception in child index '%s'", e.getMessage());
                resend = true;
            }
        } else {
            resend = true;
            log.errorf("parent not available for child kogitoprocinstanceid '%s'", data.getKogitoprocinstanceid());
        }
        
        if (resend) {
            log.errorf("Child aborted! Parent missing");
            resendChild(data);
        }

        return message.ack();
    }
    
    private void resendChild(Child data) {
        try {
            childEmitter.send(Record.of(data.getId(), data))
            .whenComplete((success, failure) -> {
                if (failure != null) {
                    log.errorf("Failed to publish child data in resend %s ", failure.getMessage());
                }
            });
        } catch (Exception e) {
            log.errorf("Exception in publish child data in resend '%s'", e.getMessage());
        }
    }

    /**
     * Consume Update data from redpanda
     * @param data Update data
     * @throws IOException
     */
    @Incoming("update-in")
    @Blocking
    public CompletionStage<Void> receiveUpdateData(Message<Update> message) throws IOException {

        AtomicBoolean resend = new AtomicBoolean(false);
        Update data = message.getPayload();
        List<Parent> parents = es.searchParent("kogitoprocinstanceid", data.getKogitoprocinstanceid());
        // Check if parent exists
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
                    resend.set(true);
                    log.errorf("exception in parent index at update kogitoprocinstanceid '%s' --- '%s'", data.getKogitoprocinstanceid(), e.getMessage());
                    return;
                }
            });

            
        } else {
            resend.set(true);
            log.errorf("parent not available for update kogitoprocinstanceid '%s'", data.getKogitoprocinstanceid());
        }

        if (resend.get()) {
            log.errorf("Update aborted! Parent missing");
            resendUpdate(data);
        }
        
        return message.ack();
    }

    private void resendUpdate(Update data) {
        try {
            updateEmitter.send(Record.of(data.getId(), data))
            .whenComplete((success, failure) -> {
                if (failure != null) {
                    log.errorf("Failed to publish update data in resend '%s'", failure.getMessage());
                }
            });
        } catch (Exception e) {
            log.errorf("Exception in publish update data in resend '%s'", e.getMessage());
        }
    }

}
