package com.example.androidepsi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StudentActivity extends AppCompatActivity {
    private TextView nom, prenom, email, grp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            getSupportActionBar().setTitle(bundle.getString("nom") + " "+ bundle.getString("prenom"));
        }else{
            getSupportActionBar().setTitle("Erreur");
        }

        setContentView(R.layout.activity_student);


        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        email = findViewById(R.id.email);
        grp = findViewById(R.id.groupe);


        if(bundle!=null){
            nom.setText(bundle.getString("nom"));
            prenom.setText(bundle.getString("prenom"));
            email.setText(bundle.getString("email"));
            grp.setText(bundle.getString("groupe"));
        }

    }
}