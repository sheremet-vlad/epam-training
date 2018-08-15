package com.epam.training.tasks.task4.exception;

public class DataParserAppException extends Exception {
    public DataParserAppException() {
    }

    public DataParserAppException(String message) {
        super(message);
    }

    public DataParserAppException(Throwable cause) {
        super(cause);
    }

    public DataParserAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
