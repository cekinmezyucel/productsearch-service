package com.codetask.service.productsearch.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticModelRepository extends ElasticsearchRepository<ElasticModel, Long> {}
