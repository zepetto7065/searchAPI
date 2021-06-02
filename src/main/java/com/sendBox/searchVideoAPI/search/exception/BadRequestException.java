package com.sendBox.searchVideoAPI.search.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super("Bad Request , check request param ");
    }

}


