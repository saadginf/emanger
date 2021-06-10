package com.eventsvc.eventservice.exceptions;

public class LibbeleExceptionResponse {

    private String erreur;

    public LibbeleExceptionResponse(String error) {
        erreur = error;
    }

    public String getError() {
        return erreur;
    }

    public void setError(String error) {
        erreur = error;
    }

}