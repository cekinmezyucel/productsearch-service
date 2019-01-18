package com.codetask.service.productsearch.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.api.response.ModelResponse;
import com.codetask.service.productsearch.elasticsearch.ElasticModel;
import com.codetask.service.productsearch.elasticsearch.ElasticModelRepository;
import com.codetask.service.productsearch.exception.model.ProductSearchException;

@Service
public class SearchService {

  private ElasticsearchOperations operations;
  private ElasticModelRepository elasticModelRepository;

  @Autowired
  public SearchService(
      ElasticsearchOperations operations, ElasticModelRepository elasticModelRepository) {
    this.operations = operations;
    this.elasticModelRepository = elasticModelRepository;
  }

  /** Populates Elasticsearch @Async */
  @Async
  public void refreshElastic(List<ModelResponse> models) {
    try {
      operations.putMapping(ElasticModel.class);
      elasticModelRepository.saveAll(getAllElasticModels(models));
    } catch (Exception e) {
      throw new ProductSearchException("PRODUCTSEARCH003", e);
    }
  }

  private List<ElasticModel> getAllElasticModels(List<ModelResponse> models) {
    return models.stream()
        .map(m -> new ElasticModel(m.getId(), m.getName(), m.getBrandResponse().getName()))
        .collect(Collectors.toList());
  }
}
