package org.demo.elasticsearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.demo.model.child.Child;
import org.demo.model.parent.Parent;
import org.demo.model.update.Update;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.jboss.logging.Logger;

import io.smallrye.common.annotation.Blocking;
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

    private boolean indexExists(String indexName) throws IOException {
        GetIndexRequest request = new GetIndexRequest();
        request.indices(indexName);
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);

        return exists;
    }
    
    private boolean createIndex(String indexName) throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(idxParent);
        org.elasticsearch.action.admin.indices.create.CreateIndexResponse createIndex = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        
        return createIndex.isAcknowledged();
    }
    
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
        
        if (!this.indexExists(idxParent)) {
            this.createIndex(idxParent);
        }

        index(request, idxParent);

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
        List<Parent> parents = this.searchParent("kogitoprocinstanceid", data.getKogitoprocinstanceid());
        if (parents != null && parents.size() > 0) {
            IndexRequest request = new IndexRequest(idxChild); 
            request.id(data.getId());
            request.source(JsonObject.mapFrom(data).toString(), XContentType.JSON); 
            index(request, idxParent);
    
            return message.ack();
        }

        return null;
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
        List<Parent> parents = this.searchParent("kogitoprocinstanceid", data.getKogitoprocinstanceid());
        if (parents != null && parents.size() > 0) {
            parents.stream().forEachOrdered(d -> {
                IndexRequest request = new IndexRequest(idxParent);
                request.id(d.getId());
                
                // Do this to handle different types of value of VariableValue
                if (data.getData().getVariableValue().getLastName() != null) {
                    log.error("Parent matched from update {} {}", " parent id I " + d.getId(), null);
                    d.getData().getVariables().setTraveller(data.getData().getVariableValue());
                } else {
                    log.error("Parent matched from update {} {}", " parent id II " + d.getId(), null);
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
                    if (!this.indexExists(idxParent)) {
                        this.createIndex(idxParent);
                    }
                } catch (IOException e) {
                    log.error("parent index check failed: {}", e);
                }
                
                index(request, idxParent);
            });

            return message.ack();
        
        } else {
            log.error("Parent not found for: {}", "parent id III " + data.getKogitoprocinstanceid(), null);
        }
        return null;
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

    private List<Parent> searchParent(String term, String match) throws IOException {
        List<Parent> results = null;
        
        try {
            SearchRequest searchRequest = new SearchRequest(idxParent);
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            searchSourceBuilder.query(QueryBuilders.matchQuery(term, match));
            searchRequest.source(searchSourceBuilder);

            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHits hits = searchResponse.getHits();
            results = new ArrayList<>(hits.getHits().length);
            for (SearchHit hit : hits.getHits()) {
                String sourceAsString = hit.getSourceAsString();
                JsonObject json = new JsonObject(sourceAsString);
                results.add(json.mapTo(Parent.class));
            }
        } catch (Exception e) {
            log.error("exception in elasticsearch search {}", e);    
        }

        return results;
    }
}
