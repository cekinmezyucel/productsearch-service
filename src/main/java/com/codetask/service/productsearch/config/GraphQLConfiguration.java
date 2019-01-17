package com.codetask.service.productsearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codetask.service.productsearch.db.repository.BrandRepository;
import com.codetask.service.productsearch.db.repository.ModelRepository;
import com.codetask.service.productsearch.elasticsearch.service.ElasticModelService;
import com.codetask.service.productsearch.resolver.Query;

@Configuration
public class GraphQLConfiguration {

  @Bean
  public Query query(
      BrandRepository brandrepository,
      ModelRepository modelRepository,
      ElasticModelService elasticModelService) {
    return new Query(brandrepository, modelRepository, elasticModelService);
  }
}
