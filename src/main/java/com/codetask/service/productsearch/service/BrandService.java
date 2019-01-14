package com.codetask.service.productsearch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.api.response.BrandResponse;
import com.codetask.service.productsearch.db.entity.Brand;
import com.codetask.service.productsearch.db.repository.BrandRepository;

@Service
public class BrandService {

  @Autowired private BrandRepository brandRepository;

  public List<BrandResponse> findAllBrands() {
    Iterable<Brand> brands = brandRepository.findAll();

    return new ArrayList<>();
  }
}
