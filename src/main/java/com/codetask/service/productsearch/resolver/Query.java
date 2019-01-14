package com.codetask.service.productsearch.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.codetask.service.productsearch.db.entity.Brand;
import com.codetask.service.productsearch.db.entity.Model;
import com.codetask.service.productsearch.db.repository.BrandRepository;
import com.codetask.service.productsearch.db.repository.ModelRepository;

public class Query implements GraphQLQueryResolver {

  private BrandRepository brandrepository;
  private ModelRepository modelRepository;

  public Query(BrandRepository brandrepository, ModelRepository modelRepository) {
    this.brandrepository = brandrepository;
    this.modelRepository = modelRepository;
  }

  public Iterable<Model> findAllModels() {
    return modelRepository.findAll();
  }

  public Iterable<Brand> findAllBrands() {
    return brandrepository.findAll();
  }
}
