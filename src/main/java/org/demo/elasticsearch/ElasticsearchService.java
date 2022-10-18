package org.demo.elasticsearch;

import java.io.IOException;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.demo.model.child.Child;
import org.demo.model.parent.Parent;
import org.demo.model.update.Update;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.jboss.logging.Logger;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.reactive.messaging.kafka.Record;
import io.vertx.core.json.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ApplicationScoped
public class ElasticsearchService {

    Logger log = Logger.getLogger(ElasticsearchService.class, "kpalmab");
    
    @Inject
    RestHighLevelClient restHighLevelClient;
    
    final String idxParent = "parent";
    final String idxChild = "child";
    final String idxUpdate = "update";

    /**
     * Consume Parent data from redpanda
     * @param data Parent data
     * @throws IOException
     */
    @Incoming("parent-in")
    @Blocking
    public void receiveParentData(Record<String, Parent> data) throws IOException {
        IndexRequest request = new IndexRequest(idxParent); 
        request.id(data.key());
        request.source(JsonObject.mapFrom(data.value()).toString(), XContentType.JSON); 
        index(request, idxParent);
    }

    /**
     * Consume Child data from redpanda
     * @param data Child data
     * @throws IOException
     */
    @Incoming("child-in")
    @Blocking
    public void receiveChildData(Record<String, Child> data) throws IOException {
        IndexRequest request = new IndexRequest(idxChild); 
        request.id(data.key());
        request.source(JsonObject.mapFrom(data.value()).toString(), XContentType.JSON);
        index(request, idxChild);
    }
    
    /**
     * Consume Update data from redpanda
     * @param data Update data
     * @throws IOException
     */
    @Incoming("update-in")
    @Blocking
    public void receiveUpdateData(Record<String, Update> data) throws IOException {
        IndexRequest request = new IndexRequest(idxUpdate);
        request.id(data.key());
        request.source(JsonObject.mapFrom(data.value()).toString(), XContentType.JSON); 
        index(request, idxUpdate);
    }

    /**
     * Index elasticsearch requests
     * @param request Request data
     * @param indexName Index name
     */
    private void index(IndexRequest request, String indexName) {
        try {
            restHighLevelClient.index(request, RequestOptions.DEFAULT);  
        } catch (Exception e) {
            log.error("Unable to index {} data {}", indexName, e);
        }
    }
}
