package com.eventsvc.eventservice.exceptions;

public class LibbeleExceptionResponse {

    private String erreur;

    public LibbeleExceptionResponse(String libelle) {
        erreur = libelle;
    }

    public String getLibelle() {
        return erreur;
    }

    public void setLibelle(String libelle) {
        erreur = libelle;
    }

}