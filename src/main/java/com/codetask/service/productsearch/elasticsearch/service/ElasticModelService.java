package com.codetask.service.productsearch.elasticsearch.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.elasticsearch.ElasticModel;
import com.codetask.service.productsearch.service.ModelService;

@Service
public class ElasticModelService {

  private ModelService modelService;

  @Autowired
  public ElasticModelService(ModelService modelService) {
    this.modelService = modelService;
  }

  public List<ElasticModel> getAllElasticModels() {
    return modelService.getAllModels().stream()
        .map(m -> new ElasticModel(m.getId(), m.getName(), m.getBrandResponse().getName()))
        .collect(Collectors.toList());
  }
}
