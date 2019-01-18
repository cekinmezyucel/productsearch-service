package com.codetask.service.productsearch.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codetask.service.productsearch.api.resolver.Query;
import com.codetask.service.productsearch.elasticsearch.service.ElasticModelService;
import com.codetask.service.productsearch.service.BrandService;
import com.codetask.service.productsearch.service.ModelService;

@Configuration
public class GraphQLConfiguration {

  /**
   * GraphQL Query init.
   *
   * @param brandService
   * @param modelService
   * @param elasticModelService
   * @return
   */
  @Bean
  public Query query(
      BrandService brandService,
      ModelService modelService,
      ElasticModelService elasticModelService) {
    return new Query(brandService, modelService, elasticModelService);
  }
}
