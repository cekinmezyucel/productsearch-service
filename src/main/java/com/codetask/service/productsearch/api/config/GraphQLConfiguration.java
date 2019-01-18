package com.codetask.service.productsearch.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codetask.service.productsearch.api.resolver.Mutation;
import com.codetask.service.productsearch.api.resolver.Query;
import com.codetask.service.productsearch.elasticsearch.ElasticModelService;
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
   * @return @{@link Query}
   */
  @Bean
  public Query query(
      BrandService brandService,
      ModelService modelService,
      ElasticModelService elasticModelService) {
    return new Query(brandService, modelService, elasticModelService);
  }

  /**
   * GraphQL Mutation Init.
   *
   * @param brandService
   * @param modelService
   * @return @{@link Mutation}
   */
  @Bean
  public Mutation mutation(BrandService brandService, ModelService modelService) {
    return new Mutation(modelService, brandService);
  }
}
