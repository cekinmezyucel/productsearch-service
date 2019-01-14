package com.codetask.service.productsearch.resolver;

import java.util.ArrayList;
import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.codetask.service.productsearch.entity.Brand;
import com.codetask.service.productsearch.entity.Model;
import com.codetask.service.productsearch.repository.Brandrepository;
import com.codetask.service.productsearch.repository.ModelRepository;

public class Query implements GraphQLQueryResolver {

  private Brandrepository brandrepository;
  private ModelRepository modelRepository;

  public Query(Brandrepository brandrepository, ModelRepository modelRepository) {
    this.brandrepository = brandrepository;
    this.modelRepository = modelRepository;
  }

  public List<Model> findAllModels() {
    List<Model> models = new ArrayList<>();
    models.add(new Model(1L, "Galaxy 7", new Brand(1L, "Samsung")));
    return models;
  }

  public List<Brand> findAllBrands() {
    List<Brand> brands = new ArrayList<>();
    brands.add(new Brand(1L, "Samsung"));
    return brands;
  }
}
