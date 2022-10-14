package com.SpringAPI.SpringAPI.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity

public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private String firstName;
    private String lastName;
    private String language;
    @JsonBackReference
    @OneToOne(mappedBy = "author")
    private Book book;

    public Author() {
    }

    public Author(int id, String firstName, String lastName, String language, Book book) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.language = language;
        this.book = book;
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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", language='" + language + '\'' +
                ", book=" + book +
                '}';
    }
}
