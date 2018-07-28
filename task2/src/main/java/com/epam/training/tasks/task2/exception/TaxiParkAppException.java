package com.epam.training.tasks.task2.exception;

public class TaxiParkAppException extends Exception {

    public TaxiParkAppException() {
    }

    public TaxiParkAppException(String message) {
        super(message);
    }

    public TaxiParkAppException(Throwable cause) {
        super(cause);
    }

    public TaxiParkAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
