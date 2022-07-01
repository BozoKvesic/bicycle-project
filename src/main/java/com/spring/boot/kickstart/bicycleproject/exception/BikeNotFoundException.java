package com.spring.boot.kickstart.bicycleproject.exception;

public class BikeNotFoundException extends RuntimeException {

    public BikeNotFoundException(final int id) {
        super("Could not find bike " + id);
    }

    public BikeNotFoundException(final String brand) {
        super("Could not find bikes " + brand);
    }

}
