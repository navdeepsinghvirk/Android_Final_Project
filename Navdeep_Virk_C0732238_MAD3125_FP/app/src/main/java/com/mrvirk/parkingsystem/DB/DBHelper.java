package com.mrvirk.parkingsystem.DB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME = "dbParking";
    private static final int DB_VERSION = 2;

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String userTable = "CREATE TABLE " + DBLogin.TABLE_USER
                + "(" + DBLogin.KEY_USER_EMAIL + " TEXT PRIMARY KEY, "
                + DBLogin.KEY_USER_PASSWORD + " TEXT )";

        db.execSQL(userTable);

        String addTickettble = "CREATE TABLE " + DBAddTicket.TABLE_ADDTICKET
                + "(" + DBAddTicket.KEY_VEHICLE_NUMBER + " TEXT PRIMARY KEY, "

                + DBAddTicket.KEY_VEHICLE_BRAND + " TEXT , "
                + DBAddTicket.KEY_COLOR + " TEXT , "
                + DBAddTicket.KEY_POSITION + " TEXT, "
                + DBAddTicket.KEY_LANE + " TEXT , "
                + DBAddTicket.KEY_PAYMETHOD + " TEXT , "
                + DBAddTicket.KEY_TIME + " TEXT )";

        db.execSQL(addTickettble);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE " + DBLogin.TABLE_USER);

        onCreate(db);

        db.execSQL("DROP TABLE " + DBAddTicket.TABLE_ADDTICKET);

        onCreate(db);
    }


    public List<String> getAllLabels() {
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DBAddTicket.TABLE_ADDTICKET;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;

    }

}
