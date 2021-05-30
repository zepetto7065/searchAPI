package com.sendBox.searchVideoAPI.search.Exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super("Bad Request , check request param ");
    }

}


