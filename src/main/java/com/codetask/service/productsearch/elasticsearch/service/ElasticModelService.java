package com.codetask.service.productsearch.elasticsearch.service;

import java.util.List;
import java.util.stream.Collectors;

import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.elasticsearch.ElasticModel;
import com.codetask.service.productsearch.service.ModelService;

@Service
public class ElasticModelService {

  private ModelService modelService;
  private ElasticsearchTemplate elasticsearchTemplate;

  @Autowired
  public ElasticModelService(
      ModelService modelService, ElasticsearchTemplate elasticsearchTemplate) {
    this.modelService = modelService;
    this.elasticsearchTemplate = elasticsearchTemplate;
  }

  public List<ElasticModel> getAllElasticModels() {
    return modelService.findAllModels().stream()
        .map(m -> new ElasticModel(m.getId(), m.getName(), m.getBrandResponse().getName()))
        .collect(Collectors.toList());
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
}
