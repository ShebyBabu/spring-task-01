package com.stackroute.userservice.exceptions;


//exception class for error handling if a particular track is not found
public class TrackNotFoundException extends Exception {
    private String message;

    public TrackNotFoundException() {
    }

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage()  {
        return message;
    }
}
