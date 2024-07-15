package com.example.tripease.exception;

import com.example.tripease.Model.Customer;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(String msg){
        super(msg);
    }
}
