package com.stackroute.userservice.exceptions;

public class TrackAlreadyExistException extends Exception{
    private String message;

    public TrackAlreadyExistException() {
    }

    public TrackAlreadyExistException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage()  {
        return message;
    }
}



