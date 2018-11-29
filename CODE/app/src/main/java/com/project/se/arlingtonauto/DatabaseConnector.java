package com.project.se.arlingtonauto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseConnector extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ArlingtonAutoRentals.db";
    // USER TABLE
    public static final String TABLE_NAME = "user_table";
    public static final String ID = "srno";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String ROLE = "role";
    public static final String UTAID = "uta_id";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String ADDRESS = "address";
    public static final String CLUB = "club_membership";


    // Car table


    public DatabaseConnector(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(username Text  NOT NULL   DEFAULT ('user'),password Text  NOT NULL   DEFAULT ('pass'),role Text  NOT NULL   DEFAULT ('user'),uta_id Integer  NOT NULL   DEFAULT (111),email Text  NOT NULL   DEFAULT ('x@x.com'),phone Integer  NOT NULL   DEFAULT (123456789), address Text  NOT NULL   DEFAULT ('NO ADDRESS'),club_membership Text  NOT NULL   DEFAULT ('NO'),srno Integer Primary Key Autoincrement  NOT NULL  )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String username, String password, String role, int utaid, String email, long phone, String address, String club) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME, username);
        contentValues.put(PASSWORD, password);
        contentValues.put(ROLE, role);
        contentValues.put(UTAID, utaid);
        contentValues.put(EMAIL, email);
        contentValues.put(PHONE, phone);
        contentValues.put(ADDRESS, address);
        contentValues.put(CLUB, club);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            Log.d("DataInserted","False");
        } else {
            Log.d("DataInserted","True");
        }
        db.close();
        return true;
    }

    public boolean checkUser(String username, String password) {

        // array of columns to fetch
        String[] columns = {
                ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = USERNAME + " = ?" + " AND " + PASSWORD + " = ?";

        // selection arguments
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        cursor.moveToFirst();

        int cursorCount = cursor.getCount();
        Log.d("cursorCount", cursorCount+"");

        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }

        return false;
    }

    public boolean updateData(String username, String password, String role, String utaid, String email, String phone, String address, String club) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME, username);
        contentValues.put(PASSWORD, password);
        contentValues.put(ROLE, role);
        contentValues.put(UTAID, utaid);
        contentValues.put(EMAIL, email);
        contentValues.put(PHONE, phone);
        contentValues.put(ADDRESS, address);
        contentValues.put(CLUB, club);
        long result = db.update(TABLE_NAME, contentValues, "UTA_ID = ?", new String[]{utaid});
        if (result == -1) {
            Log.d("DataInserted", "False");
        } else {
            Log.d("DataInserted", "True");
        }
        db.close();
        return true;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
