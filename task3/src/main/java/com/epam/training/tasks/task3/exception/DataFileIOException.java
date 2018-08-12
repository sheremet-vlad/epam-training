package com.epam.training.tasks.task3.exception;

public class DataFileIOException extends GreenHouseAppException {

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
