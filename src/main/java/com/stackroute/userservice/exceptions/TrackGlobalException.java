package com.stackroute.userservice.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TrackGlobalException {

    @ExceptionHandler(TrackAlreadyExistException.class)
    public ResponseForException handleTrackAlreadyExistsException(TrackAlreadyExistException trackAlreadyExistException,final HttpServletRequest request) {

        ResponseForException error = new ResponseForException();
        error.setErrorMessage(trackAlreadyExistException.getMessage());
        error.setRequestedURI(request.getRequestURI());

        return error;
    }

    @ExceptionHandler(TrackNotFoundException.class)
    public ResponseForException handleTrackNotFoundException(TrackNotFoundException trackNotFoundException,final HttpServletRequest request) {

        ResponseForException error = new ResponseForException();
        error.setErrorMessage(trackNotFoundException.getMessage());
        error.setRequestedURI(request.getRequestURI());

        return error;
    }
}
