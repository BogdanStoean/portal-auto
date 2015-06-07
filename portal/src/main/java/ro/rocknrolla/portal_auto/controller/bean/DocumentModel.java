package ro.rocknrolla.portal_auto.controller.bean;

import ro.rocknrolla.portal_auto.entities.Document;

import java.beans.Transient;
import java.util.Date;

public class DocumentModel {

    private Long id;
    private String name;
    private Date activationDate;
    private Date expirationDate;

    private Long carId;

    public DocumentModel() {
    }

    public DocumentModel(Document document) {
        this.id = document.getId();
        this.name = document.getName();
        this.activationDate = document.getActivationDate();
        this.expirationDate = document.getExpirationDate();
        this.carId = document.getCar().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }


}
