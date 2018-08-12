package com.epam.training.tasks.task3.exception;

public class IllegalTypeOfParserException extends GreenHouseAppException {
    public IllegalTypeOfParserException() {
    }

    public IllegalTypeOfParserException(String message) {
        super(message);
    }

    public IllegalTypeOfParserException(Throwable cause) {
        super(cause);
    }

    public IllegalTypeOfParserException(String message, Throwable cause) {
        super(message, cause);
    }
}
