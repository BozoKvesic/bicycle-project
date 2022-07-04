package com.spring.boot.kickstart.bicycleproject.exception;

public class BikeNotFoundException extends RuntimeException {

    public BikeNotFoundException(final int id) {
        super("Could not find bike by ID: " + id);
    }

}
