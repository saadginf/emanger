package com.eventsvc.eventservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LibbeleException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public LibbeleException(String message) {
        super(message);
    }

}