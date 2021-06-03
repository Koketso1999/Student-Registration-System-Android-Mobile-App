package com.example.morapedi17000504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import static android.os.Build.ID;

public class DatabaseHelper extends SQLiteOpenHelper {

//    Table Name
    public static final String TABLE_NAME = "STUDENT_DETAILS";

//   Table Columns
    public static final String  _ID = "_id";
    public static final String  FIRST_NAME = "first_name";
    public static final String  LAST_NAME = "last_name";
    public static final String  POSTAL_ADDRESS = "postal_address";
    public static final String  EMAIL_ADDRESS = "email_address";
    public static final String  NEXT_OF_KIN = "next_of_kin";
    public static final String  FACULTY = "faculty";
    public static final String  PROGRAMME = "programme";
    public static final int CONTACT_NUMBER = Integer.parseInt("contact_number");
    public static final int CONTACT_KIN = Integer.parseInt("contact_kin");

//    Database Information
    static final String DB_NAME = "SEABO_UNIVERSITY_DB";

//    Database Version
    static final int DB_VERSION = 1;


//    Creating Table Query
    public static final String CREATE_TABLE = "create table" +
        TABLE_NAME + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
        FIRST_NAME + " TEXT NOT NULL, " +
        LAST_NAME + " TEXT NOT NULL, " +
        POSTAL_ADDRESS + " TEXT NOT NULL, " +
        EMAIL_ADDRESS + " TEXT NOT NULL, " +
        NEXT_OF_KIN + " TEXT NOT NULL, " +
        FACULTY + " TEXT NOT NULL, " +
        PROGRAMME + " TEXT NOT NULL, " +
        CONTACT_NUMBER + " TEXT , " +
        CONTACT_KIN + " TEXT); " ;


//    Constructor
    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

//        Execute the query
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}