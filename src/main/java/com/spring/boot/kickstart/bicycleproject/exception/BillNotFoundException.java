package com.spring.boot.kickstart.bicycleproject.exception;

public class BillNotFoundException extends RuntimeException {

    BillNotFoundException() {
        super("Could not find bill");
    }

}
