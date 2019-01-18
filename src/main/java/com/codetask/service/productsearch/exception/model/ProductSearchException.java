package com.codetask.service.productsearch.exception.model;

import com.codetask.service.productsearch.exception.base.BaseException;

public class ProductSearchException extends BaseException {

  private static final long serialVersionUID = 7918272605764458729L;

  public ProductSearchException(String code, Object... parameters) {
    super(code, parameters);
  }
}
