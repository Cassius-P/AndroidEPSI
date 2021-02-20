package com.example.androidepsi.utils.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.androidepsi.R;
import com.example.androidepsi.utils.entities.Categorie;

import java.util.ArrayList;

public class CategoriesAdapter extends ArrayAdapter<Categorie> {

    public CategoriesAdapter(Context context, ArrayList<Categorie> categories) {
        super(context, 0, categories);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Categorie categorie = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.category_item, parent, false);
        }

        TextView rayonName = (TextView) convertView.findViewById(R.id.rName);

        rayonName.setText(categorie.getName());
        return convertView;
    }
}