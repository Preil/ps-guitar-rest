package com.guitar.config;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ControllerConfig {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "Invalid Data sent to server")
    public void notValid(){
        // add some code here for logging or messaging
    }
}
