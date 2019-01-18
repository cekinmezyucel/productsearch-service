package com.codetask.service.productsearch.exception.model;

import java.io.Serializable;

public class ExceptionResult implements Serializable {

  private static final long serialVersionUID = 5329371860978318741L;

  private String code;
  private String statusCode;
  private String userMessage;

  public ExceptionResult() {}

  /**
   * Constructor with all fields.
   *
   * @param code
   * @param statusCode
   * @param userMessage
   */
  public ExceptionResult(String code, String statusCode, String userMessage) {
    super();
    this.code = code;
    this.statusCode = statusCode;
    this.userMessage = userMessage;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getUserMessage() {
    return userMessage;
  }

  public void setUserMessage(String userMessage) {
    this.userMessage = userMessage;
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }
}
