package com.example.morapedi17000504;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {

//    Declaring the variables and objects
    private DatabaseHelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

//    Constructor
    public DBManager(Context c){
        context = c;
    }

// Calling the DB Methods
    public DBManager open() throws SQLException{
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public void insert(String first_name, String last_name, String postal_address,
                       String email_address, String next_of_kin, String faculty, String programme,
                       String contact_number, String contact_kin ){

        ContentValues contentValues = new ContentValues();
                contentValues.put(DatabaseHelper.FIRST_NAME, first_name);
                contentValues.put(DatabaseHelper.LAST_NAME, last_name);
                contentValues.put(DatabaseHelper.POSTAL_ADDRESS, postal_address);
                contentValues.put(DatabaseHelper.EMAIL_ADDRESS, email_address);
                contentValues.put(DatabaseHelper.NEXT_OF_KIN, next_of_kin);
                contentValues.put(DatabaseHelper.FACULTY, faculty);
                contentValues.put(DatabaseHelper.PROGRAMME, programme);
                contentValues.put(String.valueOf(DatabaseHelper.CONTACT_NUMBER), contact_number);
                contentValues.put(String.valueOf(DatabaseHelper.CONTACT_KIN), contact_kin);

//                Insert into the database
                database.insert(DatabaseHelper.TABLE_NAME,null,contentValues);

    }

    public Cursor fetch(){

        String[] columns = new String[] {DatabaseHelper._ID,
        DatabaseHelper.FIRST_NAME, DatabaseHelper.LAST_NAME, DatabaseHelper.POSTAL_ADDRESS,
                DatabaseHelper.EMAIL_ADDRESS, DatabaseHelper.NEXT_OF_KIN, DatabaseHelper.FACULTY,
                DatabaseHelper.PROGRAMME, String.valueOf(DatabaseHelper.CONTACT_NUMBER),
                String.valueOf(DatabaseHelper.CONTACT_KIN)};

        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);

    if (cursor != null){
        cursor.moveToFirst();
    }
    return cursor;

    }


    public void update(long _id, String first_name, String last_name, String postal_address,
                       String email_address, String next_of_kin, String faculty,
                       String programme, String contact_number, String contact_kin  ){

        ContentValues contentValues = new ContentValues();
            contentValues.put(DatabaseHelper.FIRST_NAME, first_name);
            contentValues.put(DatabaseHelper.LAST_NAME, first_name);
            contentValues.put(DatabaseHelper.POSTAL_ADDRESS, first_name);
            contentValues.put(DatabaseHelper.EMAIL_ADDRESS, first_name);
            contentValues.put(DatabaseHelper.NEXT_OF_KIN, first_name);
            contentValues.put(DatabaseHelper.FACULTY, first_name);
            contentValues.put(DatabaseHelper.PROGRAMME, programme);
            contentValues.put(String.valueOf(DatabaseHelper.CONTACT_NUMBER), contact_number);
            contentValues.put(String.valueOf(DatabaseHelper.CONTACT_KIN), contact_kin);



    }





}
