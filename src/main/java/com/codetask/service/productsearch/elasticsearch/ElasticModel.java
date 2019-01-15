package com.codetask.service.productsearch.elasticsearch;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "elasticmodel", type = "default")
public class ElasticModel {

  @Id private Long id;
  private String modelName;
  private String brandName;

  public ElasticModel() {}

  public ElasticModel(Long id, String modelName, String brandName) {
    this.id = id;
    this.modelName = modelName;
    this.brandName = brandName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getModelName() {
    return modelName;
  }

  public void setModelName(String modelName) {
    this.modelName = modelName;
  }

  public String getBrandName() {
    return brandName;
  }

  public void setBrandName(String brandName) {
    this.brandName = brandName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ElasticModel elasticModel = (ElasticModel) o;
    return id.equals(elasticModel.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    return "ElasticModel  {"
        + "id="
        + id
        + ", modelName='"
        + modelName
        + '\''
        + ", brandName='"
        + brandName
        + '\''
        + '}';
  }
}
