package com.spp.gym_network.mainservice.exception;

public class WorkoutProvidedDataException extends RuntimeException {

    public WorkoutProvidedDataException() {
    }

    public WorkoutProvidedDataException(String message) {
        super(message);
    }

    public WorkoutProvidedDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
