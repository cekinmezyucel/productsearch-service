package com.codetask.service.productsearch.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.codetask.service.productsearch.db.entity.Brand;
import com.codetask.service.productsearch.db.entity.Model;
import com.codetask.service.productsearch.db.repository.BrandRepository;
import com.codetask.service.productsearch.db.repository.ModelRepository;
import com.codetask.service.productsearch.elasticsearch.ElasticModel;
import com.codetask.service.productsearch.elasticsearch.service.ElasticModelService;

public class Query implements GraphQLQueryResolver {

  private BrandRepository brandrepository;
  private ModelRepository modelRepository;
  private ElasticModelService elasticModelService;

  public Query(
      BrandRepository brandrepository,
      ModelRepository modelRepository,
      ElasticModelService elasticModelService) {
    this.brandrepository = brandrepository;
    this.modelRepository = modelRepository;
    this.elasticModelService = elasticModelService;
  }

  public Iterable<Model> findAllModels() {
    return modelRepository.findAll();
  }

  public Iterable<Brand> findAllBrands() {
    return brandrepository.findAll();
  }

  public List<ElasticModel> searchModelByKey(String key) throws Exception {
    return elasticModelService.searchByKey(key);
  }
}
