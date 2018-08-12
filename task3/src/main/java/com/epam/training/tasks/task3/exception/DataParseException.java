package com.epam.training.tasks.task3.exception;

public class DataParseException extends GreenHouseAppException{
    public DataParseException() {
    }

    public DataParseException(String message) {
        super(message);
    }

    public DataParseException(Throwable cause) {
        super(cause);
    }

    public DataParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
