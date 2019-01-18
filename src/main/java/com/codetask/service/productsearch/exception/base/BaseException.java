package com.codetask.service.productsearch.exception.base;

import com.codetask.service.productsearch.util.BundleUtils;

public abstract class BaseException extends RuntimeException {

  private static final long serialVersionUID = -2357399347930974342L;

  private final String code;
  private final String statusCode;
  private final transient Object[] parameters;
  private final String errorMessage;

  /**
   * Constructor.
   *
   * @param code
   * @param parameters
   */
  public BaseException(String code, Object... parameters) {
    super();
    this.code = code;
    this.parameters = parameters;
    errorMessage =
        BundleUtils.getFromStumpyBundle("error." + code.toUpperCase() + ".text", parameters);
    statusCode =
        BundleUtils.getFromStumpyBundle("error." + code.toUpperCase() + ".statusCode", parameters);
  }

  public String getCode() {
    return code;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public Object[] getParameters() {
    return parameters;
  }

  public String getErrorMessage() {
    return errorMessage;
  }
}
