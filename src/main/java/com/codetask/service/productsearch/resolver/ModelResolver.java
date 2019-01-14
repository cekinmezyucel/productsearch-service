package com.codetask.service.productsearch.resolver;

import com.coxautodev.graphql.tools.GraphQLResolver;

import com.codetask.service.productsearch.entity.Brand;
import com.codetask.service.productsearch.entity.Model;
import com.codetask.service.productsearch.repository.Brandrepository;

public class ModelResolver implements GraphQLResolver<Model> {

  private Brandrepository brandrepository;

  public ModelResolver(Brandrepository brandrepository) {
    this.brandrepository = brandrepository;
  }

  public Brand getBrand(Model model) {
    return new Brand(1L, "Samsung");
  }
}
