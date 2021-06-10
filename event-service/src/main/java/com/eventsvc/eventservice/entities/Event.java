package com.eventsvc.eventservice.entities;

import javax.persistence.Transient;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.web.multipart.MultipartFile;

import lombok.ToString;

@Entity
@ToString
public class Event {
    // ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // reference
    @NotBlank(message = "Champ Obligatoire")
    private String reference;
    // objet
    @NotBlank(message = "Champ Obligatoire")
    private String objet;
    // edition
    @NotBlank(message = "Champ Obligatoire")
    private String eventEdition;
    // bg color
    @NotBlank(message = "Champ Obligatoire")
    private String bgColor;
    // start date

    @NotBlank(message = "Champ Obligatoire")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date startDate;
    // end Date

    @NotBlank(message = "Champ Obligatoire")
    @JsonFormat(pattern = "dd-mm-yyyy")
    private Date endDate;
    // representants
    @ManyToMany
    @JoinTable(name = "REP_EVENT", joinColumns = @JoinColumn(name = "EVENT_ID"), inverseJoinColumns = @JoinColumn(name = "REP_ID"))
    private Set<Representant> representants;
    // activities
    private String activites;
    // suggestions
    private String suggestions;
    // Theme event
    @ManyToOne
    @JoinColumn(name = "ID_TH_EVENT")
    private Theme themEvent;
    // fileLink & file
    private String fileLink;
    @Transient
    private MultipartFile file;
    // Lieux
    @ManyToOne
    @JoinColumn(name = "ID_LX_EVENT")
    private Lieux lieux;
    // Created at
    @JsonFormat(pattern = "dd-mm-yyyy")
    @Column(updatable = false)
    private Date createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    public Event() {
    }

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the eventEdition
     */
    public String getEventEdition() {
        return eventEdition;
    }

    /**
     * @param eventEdition the eventEdition to set
     */
    public void setEventEdition(String eventEdition) {
        this.eventEdition = eventEdition;
    }

    /**
     * @return String return the bgColor
     */
    public String getBgColor() {
        return bgColor;
    }

    /**
     * @param bgColor the bgColor to set
     */
    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    /**
     * @return String return the activites
     */
    public String getActivites() {
        return activites;
    }

    /**
     * @param activites the activites to set
     */
    public void setActivites(String activites) {
        this.activites = activites;
    }

    /**
     * @return String return the suggestions
     */
    public String getSuggestions() {
        return suggestions;
    }

    /**
     * @param suggestions the suggestions to set
     */
    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    /**
     * @return Theme return the themEvent
     */
    public Theme getThemEvent() {
        return themEvent;
    }

    /**
     * @param themEvent the themEvent to set
     */
    public void setThemEvent(Theme themEvent) {
        this.themEvent = themEvent;
    }

    /**
     * @return String return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * @return String return the fileLink
     */
    public String getFileLink() {
        return fileLink;
    }

    /**
     * @param fileLink the fileLink to set
     */
    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }

    /**
     * @return MultipartFile return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return Date return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return Date return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return Date return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return Set<Representant> return the representants
     */
    public Set<Representant> getRepresentants() {
        return representants;
    }

    /**
     * @param representants the representants to set
     */
    public void setRepresentants(Set<Representant> representants) {
        this.representants = representants;
    }

    /**
     * @return Lieux return the lieux
     */
    public Lieux getLieux() {
        return lieux;
    }

    /**
     * @param lieux the lieux to set
     */
    public void setLieux(Lieux lieux) {
        this.lieux = lieux;
    }

    /**
     * @return String return the objet
     */
    public String getObjet() {
        return objet;
    }

    /**
     * @param objet the objet to set
     */
    public void setObjet(String objet) {
        this.objet = objet;
    }

}