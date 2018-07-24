package com.epam.training.tasks.task1.exception;

public class IllegalBasePointsException extends PyramidAppException {
    private static final long serialVersionUID = 1L;

    public IllegalBasePointsException() {
    }

    public IllegalBasePointsException(String message) {
        super(message);
    }

    public IllegalBasePointsException(Throwable cause) {
        super(cause);
    }

    public IllegalBasePointsException(String message, Throwable cause) {
        super(message, cause);
    }
}
