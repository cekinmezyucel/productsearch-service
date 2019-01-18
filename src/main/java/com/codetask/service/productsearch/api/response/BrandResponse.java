package com.codetask.service.productsearch.api.response;

import java.util.Objects;

public class BrandResponse implements ResponseBody {

  private static final long serialVersionUID = 2291597948439440307L;

  private Long id;
  private String name;

  public BrandResponse() {}

  /**
   * {@link BrandResponse} all argument constructor.
   *
   * @param id
   * @param name
   */
  public BrandResponse(Long id, String name) {
    this.id = id;
    this.name = name;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BrandResponse that = (BrandResponse) o;
    return id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "BrandResponse{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
