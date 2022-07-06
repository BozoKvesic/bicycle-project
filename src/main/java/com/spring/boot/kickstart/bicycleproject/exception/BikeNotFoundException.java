package com.spring.boot.kickstart.bicycleproject.exception;

public class BikeNotFoundException extends RuntimeException {

    public BikeNotFoundException(final int id) {
        super("Could not find bike by ID: " + id);
    }

    public BikeNotFoundException(final String brand) {
        super("Could not find bikes by brand: " + brand);
    }

    public BikeNotFoundException() {
        super("Brand and color are equal null");
    }

}
