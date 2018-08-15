package com.epam.training.tasks.task4.exception;

public class DataFileIsEmptyException extends DataFileIOException {
    public DataFileIsEmptyException() {
    }

    public DataFileIsEmptyException(String message) {
        super(message);
    }

    public DataFileIsEmptyException(Throwable cause) {
        super(cause);
    }

    public DataFileIsEmptyException(String message, Throwable cause) {
        super(message, cause);
    }
}
