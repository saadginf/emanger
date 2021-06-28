package com.eventsvc.eventservice.outils;

import java.util.ArrayList;
import java.util.List;

import com.eventsvc.eventservice.entities.Lieux;
import com.eventsvc.eventservice.entities.Representant;
import com.eventsvc.eventservice.entities.Theme;

public class Fields {
    private List<Lieux> lieux = new ArrayList<>();
    private List<Representant> representants = new ArrayList<>();
    private List<Theme> themes = new ArrayList<>();

    public Fields() {
    }

    /**
     * @return List<Lieux> return the lieux
     */
    public List<Lieux> getLieux() {
        return lieux;
    }

    /**
     * @param lieux the lieux to set
     */
    public void setLieux(List<Lieux> lieux) {
        this.lieux = lieux;
    }

    /**
     * @return List<Representant> return the representants
     */
    public List<Representant> getRepresentants() {
        return representants;
    }

    /**
     * @param representants the representants to set
     */
    public void setRepresentants(List<Representant> representants) {
        this.representants = representants;
    }

    /**
     * @return List<Theme> return the themes
     */
    public List<Theme> getThemes() {
        return themes;
    }

    /**
     * @param themes the themes to set
     */
    public void setThemes(List<Theme> themes) {
        this.themes = themes;
    }

}