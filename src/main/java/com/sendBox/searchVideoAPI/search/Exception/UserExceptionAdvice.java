package com.sendBox.searchVideoAPI.search.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UserExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String itemNotFoundHandler(ItemNotFoundException ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String badRequestHandler(BadRequestException ex) {
        return ex.getMessage();
    }
}