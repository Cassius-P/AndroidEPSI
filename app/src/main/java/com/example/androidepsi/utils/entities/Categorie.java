package com.example.androidepsi.utils.entities;

public class Categorie {
    private final String name;
    private final String products_url;

    public Categorie(String name, String products_url){
        this.name = name;
        this.products_url = products_url;
    }

    public String getName() {
        return name;
    }

    public String getProducts_url() {
        return products_url;
    }

}
