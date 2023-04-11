package com.teclead.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "CUSTOMUSER")
public class CustomUser {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;

    public CustomUser() {
        super();
    }
    public CustomUser(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User (" + this.id + "): " + this.name + " " + this.surname + " - " + this.email;
    }
}
