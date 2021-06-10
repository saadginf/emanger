package com.eventsvc.eventservice.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.ToString;

@Entity
@ToString
public class Representant {
    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long value;
    // label
    @Column(unique = true, updatable = false)
    @NotBlank(message = "Champ obligatoire")
    private String label;
    // events
    @ManyToMany(mappedBy = "representants")
    @JsonProperty(access = Access.WRITE_ONLY)
    private Set<Event> event;

    public Representant() {
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

    /**
     * @return Set<Event> return the event
     */
    public Set<Event> getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Set<Event> event) {
        this.event = event;
    }

}
