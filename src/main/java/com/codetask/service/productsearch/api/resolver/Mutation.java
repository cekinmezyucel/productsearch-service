package com.codetask.service.productsearch.api.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import com.codetask.service.productsearch.api.response.BrandResponse;
import com.codetask.service.productsearch.api.response.ModelResponse;
import com.codetask.service.productsearch.service.BrandService;
import com.codetask.service.productsearch.service.ModelService;

public class Mutation implements GraphQLMutationResolver {

  private ModelService modelService;
  private BrandService brandService;

  public Mutation(ModelService modelService, BrandService brandService) {
    this.modelService = modelService;
    this.brandService = brandService;
  }

  public BrandResponse newBrand(String name) {
    return brandService.addNewBrand(name);
  }

  public ModelResponse newModel(String name, Long brandId) {
    return modelService.addNewModel(name, brandId);
  }
}
