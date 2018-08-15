package com.epam.training.tasks.task4.exception;

public class DataFileNotFoundException extends DataParserAppException {

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
