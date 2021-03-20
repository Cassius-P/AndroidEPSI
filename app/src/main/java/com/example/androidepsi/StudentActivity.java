package com.example.androidepsi;

import androidx.appcompat.app.AppCompatActivity;
import android.transition.Explode;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class StudentActivity extends AppCompatActivity {
    private TextView nom, email, grp;
    private Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        getSupportActionBar().hide();
        setContentView(R.layout.activity_student);
        getWindow().setEnterTransition(new Explode());

        nom = findViewById(R.id.nom);
        email = findViewById(R.id.email);
        grp = findViewById(R.id.groupe);
        back = findViewById(R.id.back);

        if(bundle!=null){
            nom.setText(bundle.getString("nom")+" "+bundle.getString("prenom"));
            email.setText(bundle.getString("email"));
            grp.setText(bundle.getString("groupe"));
        }

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentActivity.super.onBackPressed();
            }
        });
    }
}