package com.example.tripease.exception;

public class DriverNotFoundException extends  RuntimeException {

    public DriverNotFoundException(String msg){
        super(msg);
    }

}
