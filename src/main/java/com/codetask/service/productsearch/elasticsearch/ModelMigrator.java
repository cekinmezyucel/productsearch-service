package com.codetask.service.productsearch.elasticsearch;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ModelMigrator {

  private ElasticModelService elasticModelService;

  @Autowired
  public ModelMigrator(ElasticModelService elasticModelService) {
    this.elasticModelService = elasticModelService;
  }

  /**
   * Populates ElasticSearch from database when the application starts.
   *
   * <p>{@link Transactional}
   *
   * <p>{@link PostConstruct}
   */
  @PostConstruct
  @Transactional
  public void initElasticSearch() {
    elasticModelService.populateElasticSearch();
  }
}
