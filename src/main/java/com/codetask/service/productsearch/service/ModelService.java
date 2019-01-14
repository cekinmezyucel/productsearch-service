package com.codetask.service.productsearch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.api.response.ModelResponse;
import com.codetask.service.productsearch.db.entity.Model;
import com.codetask.service.productsearch.db.repository.ModelRepository;

@Service
public class ModelService {

  @Autowired
  private ModelRepository modelRepository;

  public List<ModelResponse> getAllModels() {
    Iterable<Model> models = modelRepository.findAll();
    return new ArrayList<>();
  }
}
