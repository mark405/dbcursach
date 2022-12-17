package com.cursach.filmprodvider.models;

/**
 * @author mark
 */
public class Sub {
    private int id;
    private String type;
    private double price;

    public void setId(int id) {
        this.id = id;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
