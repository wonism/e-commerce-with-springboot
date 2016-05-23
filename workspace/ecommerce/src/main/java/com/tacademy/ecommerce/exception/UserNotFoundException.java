package com.tacademy.ecommerce.exception;

import com.tacademy.ecommerce.common.ResultCodes;

public class UserNotFoundException extends BaseException {

  private static final long serialVersionUID = 8928843717428163273L;

  public UserNotFoundException() {
    this(null);
  }

  public UserNotFoundException(String message) {
    super(ResultCodes.USER_NOT_FOUND, message);
  }
}
