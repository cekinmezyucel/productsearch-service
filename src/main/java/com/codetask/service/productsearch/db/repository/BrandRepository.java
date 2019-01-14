package com.codetask.service.productsearch.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codetask.service.productsearch.db.entity.Brand;

@Repository
public interface BrandRepository extends CrudRepository<Brand, Long> {}
