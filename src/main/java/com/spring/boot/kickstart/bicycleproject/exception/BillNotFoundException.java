package com.spring.boot.kickstart.bicycleproject.exception;

public class BillNotFoundException extends RuntimeException {

    public BillNotFoundException() {
        super("Could not find any bill");
    }

}
