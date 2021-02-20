package com.example.androidepsi;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.androidepsi.utils.adapter.StudentsAdapter;
import com.example.androidepsi.utils.FeedReaderContract;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class GroupActivity extends AppCompatActivity {
    private ListView students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Infos");
        setContentView(R.layout.activity_group);

        SQLiteDatabase myDB = openOrCreateDatabase("db",MODE_NO_LOCALIZED_COLLATORS,null);
        //Cursor resultSet = myDB.rawQuery("Select nom from students",null);

        Cursor resultSet2 = myDB.rawQuery("Select * from students",null);

        ListAdapter adapter = new StudentsAdapter(
                this, R.layout.list_item, resultSet2, 0 );


        students = findViewById(R.id.listStudent);
        students.setAdapter(adapter);

        students.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(GroupActivity.this, StudentActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("nom", resultSet2.getString(resultSet2.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_NOM)));
                bundle.putString("prenom", resultSet2.getString(resultSet2.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_PRENOM)));
                bundle.putString("email", resultSet2.getString(resultSet2.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL)));
                bundle.putString("groupe", resultSet2.getString(resultSet2.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_GROUPE)));

                intent.putExtras(bundle);

                startActivity(intent);

                //Toast.makeText(GroupActivity.this, resultSet2.getString(resultSet2.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL)), Toast.LENGTH_LONG).show();
            }
        });
    }
}