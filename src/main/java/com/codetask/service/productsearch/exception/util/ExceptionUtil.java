package com.codetask.service.productsearch.exception.util;

import com.codetask.service.productsearch.exception.base.BaseException;
import com.codetask.service.productsearch.exception.model.ExceptionResult;

public class ExceptionUtil {

  private ExceptionUtil() {}

  public static ExceptionResult convertException(BaseException exception) {
    return new ExceptionResult(
        exception.getCode(), exception.getStatusCode(), exception.getErrorMessage());
  }
}
