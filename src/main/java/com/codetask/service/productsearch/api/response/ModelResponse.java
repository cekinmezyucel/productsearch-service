package com.codetask.service.productsearch.api.response;

import java.util.Objects;

import com.codetask.service.productsearch.api.ResponseBody;
import com.codetask.service.productsearch.db.entity.Brand;

public class ModelResponse implements ResponseBody {

  private static final long serialVersionUID = -885799497980727180L;

  private Long id;
  private String name;
  private Brand brand;

  public ModelResponse() {}

  public ModelResponse(Long id, String name, Brand brand) {
    this.id = id;
    this.name = name;
    this.brand = brand;
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

  public Brand getBrand() {
    return brand;
  }

  public void setBrand(Brand brand) {
    this.brand = brand;
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
    return "ModelResponse{" + "id=" + id + ", name='" + name + '\'' + ", brand=" + brand + '}';
  }
}
