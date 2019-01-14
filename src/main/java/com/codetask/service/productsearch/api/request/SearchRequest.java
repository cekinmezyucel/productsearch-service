package com.codetask.service.productsearch.api.request;

import java.util.Objects;

import com.codetask.service.productsearch.api.RequestBody;

public class SearchRequest implements RequestBody {

  private static final long serialVersionUID = 6332318490718588379L;

  private String key;

  public SearchRequest() {}

  public SearchRequest(String key) {
    this.key = key;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SearchRequest that = (SearchRequest) o;
    return key.equals(that.key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key);
  }

  @Override
  public String toString() {
    return "SearchRequest{" + "key='" + key + '\'' + '}';
  }
}
