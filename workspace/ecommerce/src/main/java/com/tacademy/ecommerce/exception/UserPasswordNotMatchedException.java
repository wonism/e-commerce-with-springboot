package com.tacademy.ecommerce.exception;

import com.tacademy.ecommerce.common.ResultCodes;

public class UserPasswordNotMatchedException extends BaseException {

  private static final long serialVersionUID = 7735163299454473163L;

  public UserPasswordNotMatchedException() {
    this(null);
  }

  public UserPasswordNotMatchedException(String message) {
    super(ResultCodes.USER_PASSWORD_NOT_MATCHED, message);
  }
}
