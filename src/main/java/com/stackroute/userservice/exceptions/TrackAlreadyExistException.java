package com.stackroute.userservice.exceptions;


//exception class for handling errors if a particular track already exist
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



