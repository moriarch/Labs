package org.servlet;
import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String category;
    private String description;
    private int id;
    private int price;

    public Product(){ }

    public Product(int id, String name, int price, String category, String description){

        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }
    public Product(String name, int price, String category){

        this.name = name;
        this.price = price;
        this.category = category;
    }
    public Product(int id, String name, int price, String category){

        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}