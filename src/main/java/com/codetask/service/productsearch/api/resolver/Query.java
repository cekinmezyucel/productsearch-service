package com.codetask.service.productsearch.api.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import com.codetask.service.productsearch.api.response.BrandResponse;
import com.codetask.service.productsearch.api.response.ModelResponse;
import com.codetask.service.productsearch.elasticsearch.ElasticModel;
import com.codetask.service.productsearch.elasticsearch.service.ElasticModelService;
import com.codetask.service.productsearch.service.BrandService;
import com.codetask.service.productsearch.service.ModelService;

public class Query implements GraphQLQueryResolver {

  private BrandService brandService;
  private ModelService modelService;
  private ElasticModelService elasticModelService;

  /**
   * {@link Query} all argument constructor.
   *
   * @param brandService
   * @param modelService
   * @param elasticModelService
   */
  public Query(
      BrandService brandService,
      ModelService modelService,
      ElasticModelService elasticModelService) {
    this.brandService = brandService;
    this.modelService = modelService;
    this.elasticModelService = elasticModelService;
  }

  public List<ModelResponse> findAllModels() {
    return modelService.findAllModels();
  }

  public List<BrandResponse> findAllBrands() {
    return brandService.findAllBrands();
  }

  public List<ElasticModel> searchModelByKey(String key) throws Exception {
    return elasticModelService.searchByKey(key);
  }
}
