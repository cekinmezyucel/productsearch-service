package com.codetask.service.productsearch.db.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Version;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

  private static final long serialVersionUID = -5196584930487711232L;

  @Column(name = "MODIFY_USER", nullable = false)
  private String modifyUser;

  @Column(name = "MODIFY_DATE", nullable = false)
  private Date modifyDate;

  @Version
  @Column(name = "VERSION", nullable = false)
  private Integer version;

  @PrePersist
  public void prePersist() {
    if (Objects.isNull(modifyUser)) {
      modifyUser = "API";
    }

    if (Objects.isNull(modifyDate)) {
      modifyDate = new Date();
    }
  }

  public String getModifyUser() {
    return modifyUser;
  }

  public void setModifyUser(String modifyUser) {
    this.modifyUser = modifyUser;
  }

  public Date getModifyDate() {
    return modifyDate;
  }

  public void setModifyDate(Date modifyDate) {
    this.modifyDate = modifyDate;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }
}
