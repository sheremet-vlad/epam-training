package com.epam.training.tasks.task1.exception;

public class FileOfPointsNotFoundException extends PyramidAppException {

    private static final long serialVersionUID = 1L;

    public FileOfPointsNotFoundException() {
    }

    public FileOfPointsNotFoundException(String message) {
        super(message);
    }

    public FileOfPointsNotFoundException(Throwable cause) {
        super(cause);
    }

    public FileOfPointsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
