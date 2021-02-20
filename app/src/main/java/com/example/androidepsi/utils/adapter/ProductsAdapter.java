package com.example.androidepsi.utils.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidepsi.R;
import com.example.androidepsi.utils.entities.Categorie;
import com.example.androidepsi.utils.entities.Product;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductsAdapter extends ArrayAdapter<Product> {

    public ProductsAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Product product = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.products_item, parent, false);
        }

        TextView productName = (TextView) convertView.findViewById(R.id.pName);
        TextView productDesc = (TextView) convertView.findViewById(R.id.pDesc);
        ImageView picture =  convertView.findViewById(R.id.pPic);

        productName.setText(product.getName());
        productDesc.setText(product.getDescription());
        Picasso.get().load(product.getPicture_url()).fit().centerCrop().into(picture);

        return convertView;
    }
}
