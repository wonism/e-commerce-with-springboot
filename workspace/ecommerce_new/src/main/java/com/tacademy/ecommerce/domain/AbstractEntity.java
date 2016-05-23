package com.tacademy.ecommerce.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@MappedSuperclass()
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(value = Include.ALWAYS)
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity<K extends Serializable> implements Serializable {

  private static final long serialVersionUID = 9222612730793852248L;

  @Column(name = "created_date", insertable = true, updatable = false)
  @CreatedDate
  protected Date createdDate;

  @Column(name = "created_by", insertable = true, updatable = false)
  @CreatedBy
  protected Long createdBy;

  @Column(name = "updated_date", insertable = true, updatable = true)
  @LastModifiedDate
  protected Date updatedDate;

  @Column(name = "updated_by", insertable = true, updatable = true)
  @LastModifiedBy
  protected Long updatedBy;

  public abstract String toString();

  public abstract K getId();

}
