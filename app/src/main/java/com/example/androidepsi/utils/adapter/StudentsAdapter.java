package com.example.androidepsi.utils.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import com.example.androidepsi.R;
import com.example.androidepsi.utils.FeedReaderContract;

public class StudentsAdapter extends ResourceCursorAdapter {

    public StudentsAdapter(Context context, int layout, Cursor cursor, int flags) {
        super(context, layout, cursor, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.idStudent);

        String nom = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_NOM));
        String prenom = cursor.getString(cursor.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_PRENOM));
        name.setText(nom +" "+ prenom);
    }
}