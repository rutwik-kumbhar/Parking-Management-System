package com.parking.ParkingManagementBackend.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<ExceptionFormat>  customerException(ResourcesNotFoundException ex , WebRequest wr){
        return  new ResponseEntity<>(ExceptionFormat.builder().message(ex.getMessage()).uri(wr.getDescription(false)).build(), HttpStatus.BAD_REQUEST);
    }

    public  ResponseEntity<ExceptionFormat> restaurantException(ResourcesNotFoundException ex , WebRequest webRequest){
        return  new ResponseEntity<ExceptionFormat>(ExceptionFormat.builder().message(ex.getMessage()).uri(webRequest.getDescription(false)).build(),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExceptionFormat> exceptionNotHandle(NoHandlerFoundException ex , WebRequest wr){
        return new ResponseEntity<>(ExceptionFormat.builder().message(ex.getMessage()).uri(wr.getDescription(false)).build(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionFormat> getException(Exception ex , WebRequest wr){
        return  new ResponseEntity<ExceptionFormat>(ExceptionFormat.builder().message(ex.getMessage()).uri(wr.getDescription(false)).build(),HttpStatus.BAD_REQUEST);
    }

}
