package com.epam.training.tasks.task1.exception;

public class PyramidAppException extends Exception{

    private static final long serialVersionUID = 1l;

    public PyramidAppException() {
    }

    public PyramidAppException(String message) {
        super(message);
    }

    public PyramidAppException(Throwable cause) {
        super(cause);
    }

    public PyramidAppException(String message, Throwable cause) {
        super(message, cause);
    }
}
