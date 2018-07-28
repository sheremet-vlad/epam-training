package com.epam.training.tasks.task2.exception;

public class IllegalSettableArgumentException extends TaxiParkAppException {
    public IllegalSettableArgumentException() {
    }

    public IllegalSettableArgumentException(String message) {
        super(message);
    }

    public IllegalSettableArgumentException(Throwable cause) {
        super(cause);
    }

    public IllegalSettableArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
