package com.example.androidepsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private Button zone1, zone2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("EPSI");
        setContentView(R.layout.activity_home);

        zone1 = findViewById(R.id.zone1);
        zone2 = findViewById(R.id.zone2);
    }

    @Override
    protected void onStart() {
        super.onStart();


        zone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, GroupActivity.class);
                startActivity(intent);
            }
        });

        zone2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( HomeActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });
    }
}