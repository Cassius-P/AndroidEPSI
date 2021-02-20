package com.example.androidepsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.widget.Toast;

import com.example.androidepsi.utils.FeedReaderContract;

import org.json.JSONException;
import org.json.JSONObject;

public class SplashScreen extends AppCompatActivity {

    private int timer = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splashscreen);
    }

    @Override
    protected void onStart() {
        super.onStart();
        try {
            verifyDB();
        }catch (Exception e){
            Toast.makeText(this,"Il semblerait qu'il y ait eu une erreur", Toast.LENGTH_LONG).show();
        }
    }

    private void startHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    private void verifyDB() throws JSONException {
        //Create or Open Database and check if user is connected

        SQLiteDatabase myDB = openOrCreateDatabase("db",MODE_NO_LOCALIZED_COLLATORS,null);

        myDB.execSQL("CREATE TABLE IF NOT EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_GROUPE + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_NOM + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_PRENOM + " TEXT)");

        Cursor resultSet = myDB.rawQuery("Select * from students",null);
        int r = resultSet.getCount();


        if(r == 0){
            ContentValues student1 = new ContentValues();
            student1.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NOM, "VARDEN");
            student1.put(FeedReaderContract.FeedEntry.COLUMN_NAME_PRENOM, "Laurent");
            student1.put(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL, "laurent.varden@epsi.fr");
            student1.put(FeedReaderContract.FeedEntry.COLUMN_NAME_GROUPE, "1");

            ContentValues student2 = new ContentValues();
            student2.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NOM, "MARTIN BARON");
            student2.put(FeedReaderContract.FeedEntry.COLUMN_NAME_PRENOM, "Yann");
            student2.put(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL, "yann.mb@epsi.fr");
            student2.put(FeedReaderContract.FeedEntry.COLUMN_NAME_GROUPE, "1");

            ContentValues student3 = new ContentValues();
            student3.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NOM, "ROPUGOPU");
            student3.put(FeedReaderContract.FeedEntry.COLUMN_NAME_PRENOM, "Léon");
            student3.put(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL, "leon.ropugopu@epsi.fr");
            student3.put(FeedReaderContract.FeedEntry.COLUMN_NAME_GROUPE, "1");

            ContentValues student4 = new ContentValues();
            student4.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NOM, "BAZATS");
            student4.put(FeedReaderContract.FeedEntry.COLUMN_NAME_PRENOM, "Tom");
            student4.put(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL, "tom.bazats@epsi.fr");
            student4.put(FeedReaderContract.FeedEntry.COLUMN_NAME_GROUPE, "2");

            myDB.insert("students", null, student1);
            myDB.insert("students", null, student2);
            myDB.insert("students", null, student3);
            myDB.insert("students", null, student4);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startHome();
                }
            }, timer);

        }else{

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    startHome();
                }
            }, timer);

        }
    }
}