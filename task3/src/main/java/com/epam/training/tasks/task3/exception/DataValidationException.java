package com.epam.training.tasks.task3.exception;

public class DataValidationException extends GreenHouseAppException{
    public DataValidationException() {
    }

    public DataValidationException(String message) {
        super(message);
    }

    public DataValidationException(Throwable cause) {
        super(cause);
    }

    public DataValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
