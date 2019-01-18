package com.codetask.service.productsearch.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.api.response.BrandResponse;
import com.codetask.service.productsearch.api.response.ModelResponse;
import com.codetask.service.productsearch.db.repository.ModelRepository;

@Service
public class ModelService {

  static final Logger LOG = LoggerFactory.getLogger(ModelService.class);

  private ModelRepository modelRepository;

  @Autowired
  public ModelService(ModelRepository modelRepository) {
    this.modelRepository = modelRepository;
  }

  /**
   * Finds and retrieves all {@link com.codetask.service.productsearch.db.entity.Model} entries from
   * database.
   *
   * @return @{@link List}
   */
  public List<ModelResponse> findAllModels() {
    return StreamSupport.stream(modelRepository.findAll().spliterator(), false)
        .map(
            m ->
                new ModelResponse(
                    m.getId(),
                    m.getName(),
                    new BrandResponse(m.getBrand().getId(), m.getBrand().getName())))
        .collect(Collectors.toList());
  }
}
