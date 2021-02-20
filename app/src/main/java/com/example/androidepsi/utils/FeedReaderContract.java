package com.example.androidepsi.utils;

import android.provider.BaseColumns;

public final class FeedReaderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private FeedReaderContract() {}

    /* Inner class that defines the table contents */
    public static class FeedEntry implements BaseColumns {
        public static final String TABLE_NAME = "students";
        public static final String COLUMN_NAME_NOM = "nom";
        public static final String COLUMN_NAME_PRENOM = "prenom";
        public static final String COLUMN_NAME_EMAIL = "email";
        public static final String COLUMN_NAME_GROUPE = "groupe";
    }
}