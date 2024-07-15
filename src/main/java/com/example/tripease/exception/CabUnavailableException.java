package com.example.tripease.exception;

public class CabUnavailableException extends RuntimeException{
    public CabUnavailableException(String msg){
        super(msg);
    }
}
