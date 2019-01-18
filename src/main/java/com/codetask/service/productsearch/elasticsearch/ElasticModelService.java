package com.codetask.service.productsearch.elasticsearch;

import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.exception.model.ProductSearchException;
import com.codetask.service.productsearch.service.ModelService;

@Service
public class ElasticModelService {

  private ElasticsearchOperations operations;
  private ModelService modelService;
  private ElasticsearchTemplate elasticsearchTemplate;
  private ElasticModelRepository elasticModelRepository;

  @Autowired
  public ElasticModelService(
      ModelService modelService,
      ElasticsearchTemplate elasticsearchTemplate,
      ElasticsearchOperations operations,
      ElasticModelRepository elasticModelRepository) {
    this.modelService = modelService;
    this.elasticsearchTemplate = elasticsearchTemplate;
    this.operations = operations;
    this.elasticModelRepository = elasticModelRepository;
  }

  /** Populates Elasticsearch @Async */
  @Async
  public void populateElasticSearch() {
    try {
      operations.putMapping(ElasticModel.class);
      elasticModelRepository.saveAll(getAllElasticModels());
    } catch (Exception e) {
      throw new ProductSearchException("PRODUCTSEARCH003", e);
    }
  }

  /**
   * Finds eligible models from ElasticSearch client. Search with string query and fuzzy query.
   *
   * @param key
   * @return List of {@link ElasticModel}
   */
  public List<ElasticModel> searchByKey(String key) {
    QueryBuilder query =
        QueryBuilders.boolQuery()
            .should(
                QueryBuilders.queryStringQuery(key)
                    .lenient(true)
                    .field("modelName")
                    .field("brandName"))
            .should(
                QueryBuilders.queryStringQuery("*" + key + "*")
                    .lenient(true)
                    .field("modelName")
                    .field("brandName"))
            .should(
                QueryBuilders.multiMatchQuery(key, "modelName", "brandName")
                    .fuzziness(Fuzziness.AUTO)
                    .fuzzyTranspositions(Boolean.TRUE));

    NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();
    return elasticsearchTemplate.queryForList(build, ElasticModel.class);
  }

  private List<ElasticModel> getAllElasticModels() {
    return modelService.findAllModels().stream()
        .map(m -> new ElasticModel(m.getId(), m.getName(), m.getBrandResponse().getName()))
        .collect(Collectors.toList());
  }
}
