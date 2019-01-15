package com.codetask.service.productsearch.api.response;

import java.util.Objects;

import com.codetask.service.productsearch.api.ResponseBody;

public class ModelResponse implements ResponseBody {

  private static final long serialVersionUID = -885799497980727180L;

  private Long id;
  private String name;
  private BrandResponse brandResponse;

  public ModelResponse() {}

  public ModelResponse(Long id, String name, BrandResponse brandResponse) {
    this.id = id;
    this.name = name;
    this.brandResponse = brandResponse;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BrandResponse getBrandResponse() {
    return brandResponse;
  }

  public void setBrandResponse(BrandResponse brandResponse) {
    this.brandResponse = brandResponse;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelResponse that = (ModelResponse) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "ModelResponse{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", brandResponse="
        + brandResponse
        + '}';
  }
}
