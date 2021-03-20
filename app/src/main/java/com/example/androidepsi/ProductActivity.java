package com.example.androidepsi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Explode;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductActivity extends AppCompatActivity {
    private TextView desc;
    private ImageView pic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setEnterTransition(new Explode());
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            getSupportActionBar().setTitle(bundle.getString("name"));
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_product);

        desc = findViewById(R.id.desc);
        pic = findViewById(R.id.pic);


        desc.setText(bundle.getString("desc"));
        Picasso.get().load(bundle.getString("pic")).fit().centerCrop().into(pic);
    }
}