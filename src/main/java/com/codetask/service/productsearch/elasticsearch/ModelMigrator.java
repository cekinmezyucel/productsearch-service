package com.codetask.service.productsearch.elasticsearch;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.codetask.service.productsearch.elasticsearch.service.ElasticModelService;

@Component
public class ModelMigrator {

  private ElasticsearchOperations operations;
  private ElasticModelRepository elasticModelRepository;
  private ElasticModelService elasticModelService;

  @Autowired
  public ModelMigrator(
      ElasticsearchOperations operations,
      ElasticModelRepository elasticModelRepository,
      ElasticModelService elasticModelService) {
    this.operations = operations;
    this.elasticModelRepository = elasticModelRepository;
    this.elasticModelService = elasticModelService;
  }

  @PostConstruct
  @Transactional
  public void populateElasticSearch() {
    operations.putMapping(ElasticModel.class);
    elasticModelRepository.saveAll(elasticModelService.getAllElasticModels());
  }
}