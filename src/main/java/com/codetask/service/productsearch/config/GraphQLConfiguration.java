package com.codetask.service.productsearch.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.codetask.service.productsearch.repository.Brandrepository;
import com.codetask.service.productsearch.repository.ModelRepository;
import com.codetask.service.productsearch.resolver.Query;

@Configuration
public class GraphQLConfiguration {

    @Bean
    public Query query(Brandrepository brandrepository, ModelRepository modelRepository) {
        return new Query(brandrepository, modelRepository);
    }
}
