package com.codetask.service.productsearch.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.api.response.BrandResponse;
import com.codetask.service.productsearch.db.repository.BrandRepository;

@Service
public class BrandService {

  private BrandRepository brandRepository;

  @Autowired
  public BrandService(BrandRepository brandRepository) {
    this.brandRepository = brandRepository;
  }

  public List<BrandResponse> findAllBrands() {
    return StreamSupport.stream(brandRepository.findAll().spliterator(), false)
        .map(b -> new BrandResponse(b.getId(), b.getName()))
        .collect(Collectors.toList());
  }
}
