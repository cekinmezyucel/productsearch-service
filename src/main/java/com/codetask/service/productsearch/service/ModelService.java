package com.codetask.service.productsearch.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.api.response.BrandResponse;
import com.codetask.service.productsearch.api.response.ModelResponse;
import com.codetask.service.productsearch.db.entity.Brand;
import com.codetask.service.productsearch.db.entity.Model;
import com.codetask.service.productsearch.db.repository.BrandRepository;
import com.codetask.service.productsearch.db.repository.ModelRepository;
import com.codetask.service.productsearch.exception.model.ProductSearchException;

@Service
public class ModelService {

  static final Logger LOG = LoggerFactory.getLogger(ModelService.class);

  private ModelRepository modelRepository;
  private BrandRepository brandRepository;
  private SearchService searchService;

  @Autowired
  public ModelService(
      ModelRepository modelRepository,
      BrandRepository brandRepository,
      SearchService searchService) {
    this.modelRepository = modelRepository;
    this.brandRepository = brandRepository;
    this.searchService = searchService;
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

  /**
   * Creates a new {@link com.codetask.service.productsearch.db.entity.Model}
   *
   * @param name
   * @return @{@link ModelResponse}
   */
  public ModelResponse addNewModel(String name, Long brandId) {
    Optional<Brand> optionalBrand = brandRepository.findById(brandId);

    if (!optionalBrand.isPresent()) {
      throw new ProductSearchException("PRODUCTSEARCH004");
    }

    Model savedModel = modelRepository.save(new Model(name, optionalBrand.get()));

    searchService.refreshElastic(findAllModels());

    return new ModelResponse(
        savedModel.getId(),
        savedModel.getName(),
        new BrandResponse(savedModel.getBrand().getId(), savedModel.getBrand().getName()));
  }
}
