package com.example.course;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhelper extends SQLiteOpenHelper {
    public static final String DBname = "register.db";

    public DBhelper(Context context) {
        super(context, "register.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
//    @Override
//    public void onCreate(SQLiteDatabase RegisterDB) {
//        RegisterDB.execSQL("create table users(username Text, passwo)")
//
////    @Override
////    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
////
////    }
//}
