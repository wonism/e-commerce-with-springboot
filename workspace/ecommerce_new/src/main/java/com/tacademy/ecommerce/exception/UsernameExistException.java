package com.tacademy.ecommerce.exception;

import com.tacademy.ecommerce.common.ResultCodes;

public class UsernameExistException extends BaseException {

  private static final long serialVersionUID = -4509503570683886400L;

  public UsernameExistException() {
    this(null);
  }

  public UsernameExistException(String message) {
    super(ResultCodes.USER_ALREADY_EXIST, message);
  }

}
