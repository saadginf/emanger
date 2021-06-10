package com.eventsvc.eventservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
   @ExceptionHandler
   public final ResponseEntity<Object> handlProjectIdEception(LibbeleException ex, WebRequest request) {

      LibbeleExceptionResponse exceptionResponse = new LibbeleExceptionResponse(ex.getMessage());
      return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
   }

}