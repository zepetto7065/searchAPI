package com.sendBox.searchVideoAPI.search.Exception;

public class MaxListLengthException extends RuntimeException {

    public MaxListLengthException(int listLength) {
        super("Max Length Over, Please Check this List Size : " + listLength);
    }

}


