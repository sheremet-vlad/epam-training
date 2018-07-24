package com.epam.training.tasks.task1.exception;

public class NullPointsDataException extends PyramidAppException {
    private static final long serialVersionUID = 1L;

    public NullPointsDataException() {
    }

    public NullPointsDataException(String message) {
        super(message);
    }

    public NullPointsDataException(Throwable cause) {
        super(cause);
    }

    public NullPointsDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
