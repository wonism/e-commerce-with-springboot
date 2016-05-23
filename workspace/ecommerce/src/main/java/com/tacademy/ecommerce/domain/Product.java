package com.tacademy.ecommerce.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tacademy.ecommerce.config.SystemPropertiesConfig;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "t_product")
@Getter
@Setter
@ToString
public class Product extends AbstractEntity<Long> {

  private static final long serialVersionUID = -1137412847720410998L;

  @Id
  @GeneratedValue
  @JsonProperty
  private Long id;

  @Column(length = 30)
  @JsonProperty
  private String name;

  @Column
  @JsonProperty
  private Double price;

  @Column(name = "image_file_name", length = 100)
  private String imageFileName;

  @Column(length = 10)
  @JsonProperty
  private String color;

  @Lob
  @JsonProperty
  private String description;

  @JsonProperty("imageUrl")
  public String getImageUrl() {
    if (this.id == null || StringUtils.isBlank(this.imageFileName))
      return null;
    return String.format("%s/product/%d/%s", System.getProperty(SystemPropertiesConfig.STORAGE_URI), this.id, this.imageFileName);
  }

  @Transient
  public String getImageUploadPath() {
    if (this.id == null)
      return null;
    return String.format("%s/product/%d", System.getProperty(SystemPropertiesConfig.STORAGE_PATH), this.id);
  }

}
