package com.example.quizapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHandler extends SQLiteOpenHelper
{
    Context context;
    public DbHandler(@Nullable Context context ) {
        super(context, "Intelliquizzdb", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String qr = "CREATE TABLE User (Id INTEGER PRIMARY KEY AUTOINCREMENT, FirstName TEXT NOT NULL, " +
                "LastName TEXT NOT NULL, Email TEXT NOT NULL, Password TEXT NOT NULL)";

        db.execSQL(qr);

    }
    public boolean AddUser(User u)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("FirstName", u.FirstName);
        cv.put("LastName", u.LastName);
        cv.put("Email", u.Email);
        cv.put("Password", u.Password);

        try {
            long insert = db.insert("User", null, cv);
            return insert != -1;
        } catch (Exception e) {
            // Handle exceptions (e.g., SQLiteException)
            Log.e("AddUser", "Error inserting user: " + e.getMessage());
            return false;
        } finally {
            db.close();
        }
    }
    public boolean checkLogin(String Email,String Password)
    {
        String qr = "SELECT * FROM User WHERE Email = ? AND Password = ?;";
        SQLiteDatabase db = getReadableDatabase();
        String[] selectionArgs={Email,Password};
        Cursor cursor = (Cursor) db.rawQuery(qr,selectionArgs);
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        } else {
            cursor.close();
            return false;
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
