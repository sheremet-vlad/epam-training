package com.epam.training.tasks.task1.exception;

public class ParseDataException extends PyramidAppException{
    private static final long serialVersionUID = 1L;

    public ParseDataException() {
    }

    public ParseDataException(String message) {
        super(message);
    }

    public ParseDataException(Throwable cause) {
        super(cause);
    }

    public ParseDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
