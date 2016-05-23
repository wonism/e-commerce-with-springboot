package com.tacademy.ecommerce.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tacademy.ecommerce.common.ResponseVO;

@ControllerAdvice(annotations = { RestController.class })
public class ExceptionHandlerAdvice {

  @ExceptionHandler(BaseException.class)
  @ResponseBody
  public ResponseVO baseExecption(BaseException ex, HttpServletRequest request) {
    return new ResponseVO(ex.getResultCode(), ex.getMessage());
  }

}
