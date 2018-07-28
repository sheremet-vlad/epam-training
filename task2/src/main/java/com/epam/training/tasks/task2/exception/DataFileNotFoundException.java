package com.epam.training.tasks.task2.exception;

import java.io.FileNotFoundException;

public class DataFileNotFoundException extends TaxiParkAppException {
    public DataFileNotFoundException() {
    }

    public DataFileNotFoundException(String message) {
        super(message);
    }

    public DataFileNotFoundException(Throwable cause) {
        super(cause);
    }

    public DataFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
