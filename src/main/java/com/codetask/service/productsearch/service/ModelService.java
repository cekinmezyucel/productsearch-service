package com.codetask.service.productsearch.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.api.response.BrandResponse;
import com.codetask.service.productsearch.api.response.ModelResponse;
import com.codetask.service.productsearch.db.entity.Model;
import com.codetask.service.productsearch.db.repository.ModelRepository;

@Service
public class ModelService {

  private ModelRepository modelRepository;

  @Autowired
  public ModelService(ModelRepository modelRepository) {
    this.modelRepository = modelRepository;
  }

  public List<ModelResponse> getAllModels() {
    Iterable<Model> models = modelRepository.findAll();
    return StreamSupport.stream(models.spliterator(), false)
        .map(
            m ->
                new ModelResponse(
                    m.getId(),
                    m.getName(),
                    new BrandResponse(m.getBrand().getId(), m.getBrand().getName())))
        .collect(Collectors.toList());
  }
}
