package org.demo.elasticsearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.demo.model.parent.Parent;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.jboss.logging.Logger;

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

    /**
     * Check if index exists
     * @param indexName
     * @return true | false
     * @throws IOException
     */
    private boolean indexExists(String indexName) throws IOException {
        GetIndexRequest request = new GetIndexRequest();
        request.indices(indexName);
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);

        return exists;
    }
    
    /**
     * Create an index
     * @param indexName
     * @return true | false
     * @throws IOException
     */
    private boolean createIndex(String indexName) throws IOException {
        try {
            CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
            org.elasticsearch.action.admin.indices.create.CreateIndexResponse createIndex = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        
            return createIndex.isAcknowledged();
        } catch (Exception e) {
            log.errorf("exception in create index '%s'", e.getMessage());
            return true;
        }
    }
    
    /**
     * Index elasticsearch requests
     * @param request Request data
     * @param indexName Index name
     * @throws IOException
     */
    public void index(IndexRequest request, String indexName) throws IOException {
        if (!this.indexExists(indexName)) {
            this.createIndex(indexName);
        }

        restHighLevelClient.index(request, RequestOptions.DEFAULT);  
    }

    /**
     * Search for parent
     * @param term  name of the field
     * @param match search value
     * @return  List of matched parents
     * @throws IOException
     */
    public List<Parent> searchParent(String term, String match) throws IOException {
        List<Parent> results = null;
        if (!this.indexExists(idxParent)) {
            this.createIndex(idxParent);
            return results;
        }
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
        }

        return results;
    }
}
