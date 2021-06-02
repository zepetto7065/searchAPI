package com.sendBox.searchVideoAPI.search.exception;

public class RequestNotFoundException extends RuntimeException {

    public RequestNotFoundException() {
        super("Could not find identity");
    }

}


