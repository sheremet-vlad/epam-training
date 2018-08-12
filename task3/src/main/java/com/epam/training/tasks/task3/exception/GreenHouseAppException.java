package com.epam.training.tasks.task3.exception;

public class GreenHouseAppException extends Exception {
    public GreenHouseAppException() {
    }

    public GreenHouseAppException(String message) {
        super(message);
    }

    public GreenHouseAppException(Throwable cause) {
        super(cause);
    }

    public GreenHouseAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
