package com.spring.boot.kickstart.bicycleproject.exception;

import java.time.LocalDate;

public class BillNotFoundException extends RuntimeException {

    public BillNotFoundException() {
        super("Could not find any bill");
    }

    public BillNotFoundException(final LocalDate date) {
        super("Could not find any bill on: " + date);
    }

}
