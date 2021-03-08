package com.spp.gym_network.mainservice.exception;

/*
In case user account does not exists in the system for a given email id.
 */
public class UnkownIdentifierException extends Exception {

    public UnkownIdentifierException() {
        super();
    }


    public UnkownIdentifierException(String message) {
        super(message);
    }


    public UnkownIdentifierException(String message, Throwable cause) {
        super(message, cause);
    }
}