package com.cursach.filmprodvider.models;

/**
 * @author mark
 */
public class Visitor {
    private int id;
    private String name;
    private String surname;
    private String genre;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGenre() {
        return genre;
    }
}
