package com.example.androidepsi.utils.entities;

import java.io.UnsupportedEncodingException;

public class Product {

    private String name, description, picture_url;

    public Product(String nom, String description, String image){

        String accentName = nom;
        String accentDesc = description;
        try {
            byte[] nameBytes = nom.getBytes("ISO-8859-1");
            byte[] descBytes = description.getBytes("ISO-8859-1");
            accentName = new String(nameBytes);
            accentDesc = new String(descBytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        this.name = accentName;
        this.description= accentDesc;
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
