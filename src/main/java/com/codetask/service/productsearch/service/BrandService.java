package com.codetask.service.productsearch.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.api.response.BrandResponse;
import com.codetask.service.productsearch.db.repository.BrandRepository;

@Service
public class BrandService {

  static final Logger LOG = LoggerFactory.getLogger(BrandService.class);

  private BrandRepository brandRepository;

  @Autowired
  public BrandService(BrandRepository brandRepository) {
    this.brandRepository = brandRepository;
  }

  /**
   * Finds and re trieves all @{@link com.codetask.service.productsearch.db.entity.Brand} entries
   * form database.
   *
   * @return {@link List}
   */
  public List<BrandResponse> findAllBrands() {
    return StreamSupport.stream(brandRepository.findAll().spliterator(), false)
        .map(b -> new BrandResponse(b.getId(), b.getName()))
        .collect(Collectors.toList());
  }
}
