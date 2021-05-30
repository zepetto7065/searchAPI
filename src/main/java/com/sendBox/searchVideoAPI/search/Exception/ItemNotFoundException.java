package com.sendBox.searchVideoAPI.search.Exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String id) {
        super("Could not find item " + id);
    }
}


