package com.example.androidepsi.utils.entities;

import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class Categorie {
    private final String name;
    private final String products_url;

    public Categorie(String name, String products_url)  {
        String accentName = name;
        try {
            byte[] nameBytes = name.getBytes("ISO-8859-1");
            accentName = new String(nameBytes);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        this.name = accentName;
        this.products_url = products_url;
    }

    public String getName() {
        return name;
    }

    public String getProducts_url() {
        return products_url;
    }
}
