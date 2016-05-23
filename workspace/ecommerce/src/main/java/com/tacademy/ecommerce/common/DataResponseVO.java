package com.tacademy.ecommerce.common;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataResponseVO<T> extends ResponseVO {

  private static final long serialVersionUID = 2718902523399739315L;

  @JsonUnwrapped
  private T data;

  public DataResponseVO(String resultCode) {
    super(resultCode);
  }

  public DataResponseVO(T data) {
    this(ResultCodes.OK);
    this.data = data;
  }

}
