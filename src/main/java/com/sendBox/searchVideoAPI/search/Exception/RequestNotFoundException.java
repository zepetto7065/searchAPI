package com.sendBox.searchVideoAPI.search.Exception;

public class RequestNotFoundException extends RuntimeException {

    public RequestNotFoundException() {
        super("Could not find identity");
    }

}


