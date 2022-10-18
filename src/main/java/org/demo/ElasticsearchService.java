package org.demo;

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

import io.smallrye.common.annotation.Blocking;
import io.smallrye.reactive.messaging.kafka.Record;
import io.vertx.core.json.JsonObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ApplicationScoped
@Getter
@Setter
@NoArgsConstructor
public class ElasticsearchService {
    @Inject
    RestHighLevelClient restHighLevelClient;
    
    @Incoming("parent-in")
    @Blocking
    public void receiveParentData(Record<String, Parent> data) throws IOException {
        IndexRequest request = new IndexRequest("parent"); 
        request.id(data.key());
        request.source(JsonObject.mapFrom(data.value()).toString(), XContentType.JSON); 
        restHighLevelClient.index(request, RequestOptions.DEFAULT); 
    }

    @Incoming("child-in")
    @Blocking
    public void receiveChildData(Record<String, Child> data) throws IOException {
        IndexRequest request = new IndexRequest("child"); 
        request.id(data.key());
        request.source(JsonObject.mapFrom(data.value()).toString(), XContentType.JSON); 
        restHighLevelClient.index(request, RequestOptions.DEFAULT); 
    }
        
    @Incoming("update-in")
    @Blocking
    public void receiveUpdateData(Record<String, Update> data) throws IOException {
        IndexRequest request = new IndexRequest("update");
        request.id(data.key());
        request.source(JsonObject.mapFrom(data.value()).toString(), XContentType.JSON); 
        restHighLevelClient.index(request, RequestOptions.DEFAULT); 
    }
}
