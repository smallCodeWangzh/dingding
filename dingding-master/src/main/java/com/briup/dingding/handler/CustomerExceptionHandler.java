package com.briup.dingding.handler;

import com.briup.dingding.exception.CustomerException;
import com.briup.dingding.util.Message;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity<Message> handler(CustomerException exception) {
       return ResponseEntity.status(exception.getCodeStatus().getCode())
               .body(new Message(exception.getCodeStatus()));
    }
}
