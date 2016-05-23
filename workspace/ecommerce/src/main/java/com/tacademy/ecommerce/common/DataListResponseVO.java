package com.tacademy.ecommerce.common;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DataListResponseVO<T> extends ResponseVO {

  private static final long serialVersionUID = -8702013692167568360L;

  private List<T> list;

  private int pageSize;

  private Integer page;

  private long fullListSize;

  public DataListResponseVO(String resultCode) {
    super(resultCode);
  }

  public DataListResponseVO(List<T> list) {
    this(ResultCodes.OK);
    this.list = list;
  }

  public DataListResponseVO(Page<T> page) {
    this(ResultCodes.OK);
    this.list = page.getContent();
    this.pageSize = page.getSize();
    this.page = page.getNumber() + 1;
    this.fullListSize = page.getTotalElements();
  }

}
