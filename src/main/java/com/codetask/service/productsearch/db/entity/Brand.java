package com.codetask.service.productsearch.db.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(
    name = "brand",
    indexes = {@Index(name = "ix_brand_name", columnList = "name", unique = true)})
public class Brand extends BaseEntity {

  private static final long serialVersionUID = 4520897126442397305L;

  @Id
  @Column(name = "id", nullable = false)
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  public Brand() {}

  public Brand(Long id) {
    this.id = id;
  }

  public Brand(String name) {
    this.name = name;
  }

  public Brand(Long id, String name) {
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
    Brand brand = (Brand) o;
    return id.equals(brand.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "Brand{" + "id=" + id + ", name='" + name + '\'' + '}';
  }
}
