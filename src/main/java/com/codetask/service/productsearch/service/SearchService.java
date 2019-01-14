package com.codetask.service.productsearch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.codetask.service.productsearch.db.entity.Model;

@Service
public class SearchService {

  public List<Model> searchByKey(String key) {
    return new ArrayList<>();
  }
}
