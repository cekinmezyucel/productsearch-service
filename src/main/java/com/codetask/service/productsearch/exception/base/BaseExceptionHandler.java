package com.codetask.service.productsearch.exception.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codetask.service.productsearch.exception.model.ExceptionResult;
import com.codetask.service.productsearch.exception.model.ProductSearchException;
import com.codetask.service.productsearch.exception.util.ExceptionUtil;

public abstract class BaseExceptionHandler {

  static final Logger LOG = LoggerFactory.getLogger(BaseExceptionHandler.class);

  /**
   * Handle Internal Exceptions.
   *
   * @param exception
   * @return {@link ExceptionResult}
   */
  protected ExceptionResult handle(Throwable exception) {
    LOG.error("An Exception occured", exception);
    return ExceptionUtil.convertException(new ProductSearchException("PRODUCTSEARCH001"));
  }
}
