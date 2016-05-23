package com.tacademy.ecommerce.exception;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class BaseException extends RuntimeException {

  private final String resultCode;

  public BaseException(String resultCode) {
    this(resultCode, null);
  }

  public BaseException(String resultCode, String debugMessage) {
    this(resultCode, debugMessage, null);
  }

  public BaseException(String resultCode, String debugMessage, Throwable cause) {
    super(debugMessage, cause);
    this.resultCode = resultCode;
  }

  public String getExceptionDebugMessage() {
    return this.toString();
  }

}
