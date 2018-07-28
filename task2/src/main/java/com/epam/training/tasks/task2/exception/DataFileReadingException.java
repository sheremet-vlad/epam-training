package com.epam.training.tasks.task2.exception;

import java.io.IOException;

public class DataFileReadingException extends TaxiParkAppException {
    public DataFileReadingException() {
    }

    public DataFileReadingException(String message) {
        super(message);
    }

    public DataFileReadingException(Throwable cause) {
        super(cause);
    }

    public DataFileReadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
