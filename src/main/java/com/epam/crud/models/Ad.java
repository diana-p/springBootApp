package com.epam.crud.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ad { //class for ad object in database

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text, lastName, firstName, eMail;

    public Ad() {
    }

    public Ad(String text, String lastName, String firstName, String eMail) {
        this.text = text;
        this.lastName = lastName;
        this.firstName = firstName;
        this.eMail = eMail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }
}
