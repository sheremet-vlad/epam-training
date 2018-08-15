package com.epam.training.tasks.task4.exception;

public class DataFileIOException extends DataParserAppException {
    public DataFileIOException() {
    }

    public DataFileIOException(String message) {
        super(message);
    }

    public DataFileIOException(Throwable cause) {
        super(cause);
    }

    public DataFileIOException(String message, Throwable cause) {
        super(message, cause);
    }
}
