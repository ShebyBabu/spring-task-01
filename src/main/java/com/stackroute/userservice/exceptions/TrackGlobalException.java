package com.stackroute.userservice.exceptions;

import com.stackroute.userservice.responses.ResponseForError;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.sound.midi.Track;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


//global exception class for exception handling globally
@ControllerAdvice
public class TrackGlobalException extends ResponseEntityExceptionHandler {

//exception handling for track not found exception
@ExceptionHandler(value = {TrackAlreadyExistException.class})
public ResponseEntity<ResponseForError> globalTrackAlreadyExists(TrackAlreadyExistException ex) throws Exception
{
    ResponseForError responseForError = new ResponseForError();
    responseForError.setErrorId(HttpStatus.BAD_REQUEST.value());
    responseForError.setErrorMessage(ex.getMessage());
    return new ResponseEntity<>(responseForError,HttpStatus.BAD_REQUEST);
}
//exception handling for track already exist exception
    @ExceptionHandler(value = {TrackNotFoundException.class})
    public ResponseEntity<ResponseForError> globalTrackNotFound(TrackNotFoundException ex) throws Exception
    {
        ResponseForError responseForError = new ResponseForError();
        responseForError.setErrorId(HttpStatus.BAD_REQUEST.value());
        responseForError.setErrorMessage(ex.getMessage());
        return new ResponseEntity<>(responseForError,HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(value = TrackAlreadyExistException.class)
    public ResponseEntity<Object> exception(TrackAlreadyExistException exception)
    {
        return new ResponseEntity<>("Music Already exists", HttpStatus.NOT_FOUND);
    }




}
