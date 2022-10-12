package com.SpringAPI.SpringAPI.Entities;

import javax.persistence.*;
import java.util.jar.Attributes;

@Entity

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String firstName;
    private String lastName;
    private String language;
      //private Book book;
    public Author() {
    }

    public Author(int id, String firstName, String lastName, String language) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
