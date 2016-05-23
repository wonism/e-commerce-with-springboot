package com.tacademy.ecommerce.exception;

import com.tacademy.ecommerce.common.ResultCodes;

public class InvalidParameterException extends BaseException {

  private static final long serialVersionUID = -6976510954438859842L;

  public InvalidParameterException() {
    this(null);
  }

  public InvalidParameterException(String message) {
    super(ResultCodes.EMPTY_PARAMETER, message);
  }

}
