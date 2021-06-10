package com.eventsvc.eventservice.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class Lieux {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long value;
    // label
    @Column(unique = true, updatable = false)
    @NotBlank(message = "Champ obligatoire")
    private String label;

    public Lieux() {
    }

    /**
     * @return Long return the value
     */
    public Long getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(Long value) {
        this.value = value;
    }

    /**
     * @return String return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

}
