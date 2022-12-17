package com.cursach.filmprodvider.models;

/**
 * @author mark
 */
public class Producer {
    private int id;
    private String name;
    private String surname;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
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
}
