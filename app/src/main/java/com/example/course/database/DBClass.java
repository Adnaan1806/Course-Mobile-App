package com.example.course.database;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBClass extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "User";
    private static final int DATABASE_VERSION = 1;


    public DBClass(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String sqlS = "CREATE TABLE Student (" +
                "student_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "email TEXT, " +
                "address TEXT, " +
                "city TEXT, " +
                "login_code TEXT, " +
                "phone TEXT, " +
                "gender CHAR(1), " +
                "DOB TEXT);";

        final String sqlC = "CREATE TABLE Course (" +
                "course_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "course_name TEXT, " +
                "start_date TEXT, " +
                "end_date TEXT, " +
                "fee REAL, " +
                "description TEXT, " +
                "maximum_part INTEGER);";

        final String sqlA = "CREATE TABLE Admin (" +
                "admin_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "admin_email TEXT, " +
                "admin_password TEXT);";

        final String sqlB = "CREATE TABLE Branch (" +
                "branch_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "branch_name TEXT, " +
                "branch_location TEXT);";


        sqLiteDatabase.execSQL(sqlS);
        sqLiteDatabase.execSQL(sqlC);
        sqLiteDatabase.execSQL(sqlA);
        sqLiteDatabase.execSQL(sqlB);
    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE Student");
        sqLiteDatabase.execSQL("DROP TABLE Admin");
        sqLiteDatabase.execSQL("DROP TABLE Course");
        sqLiteDatabase.execSQL("DROP TABLE Branch");

        onCreate(sqLiteDatabase);

    }

    /*
    * add user
    * add profile pic
    * verify email
    *
    * */


}
