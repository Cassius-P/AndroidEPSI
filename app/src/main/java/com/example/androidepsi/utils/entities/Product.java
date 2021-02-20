package com.example.androidepsi.utils.entities;

public class Product {

    private String name, description, picture_url;

    public Product(String nom, String description, String image){
        this.name = nom;
        this.description= description;
        this.picture_url = image;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPicture_url() {
        return picture_url;
    }
}
