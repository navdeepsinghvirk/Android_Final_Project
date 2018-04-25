package com.mrvirk.parkingsystem.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.mrvirk.parkingsystem.Model.Login;

import java.util.ArrayList;

public class DBLogin {
    public static final String TABLE_USER = "tblUser";
    public static final String KEY_USER_EMAIL = "useremailid";
    public static final String KEY_USER_PASSWORD = "userpassword";
    private Context context;

    private DBHelper dbHelper;

    public DBLogin(Context context) {
        this.context = context;
    }

    public void insertUser(Login login) {
        dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USER_EMAIL, login.getEmail());
        contentValues.put(KEY_USER_PASSWORD, login.getPassword());

        database.insert(TABLE_USER, null, contentValues);

        database.close();

    }

    public void updateUser(Login login) {
        dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USER_PASSWORD, login.getPassword());

        database.update(TABLE_USER, contentValues, KEY_USER_EMAIL + "=?", new String[]{login.getEmail()});

        database.close();

    }


    public void deleteUser(Login login) {
        dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        database.delete(TABLE_USER, KEY_USER_EMAIL + "=?", new String[]{login.getEmail()});

        database.close();

    }
    public ArrayList<Login> getAllUser()
    {
        dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getWritableDatabase();

        Cursor cursor = database.query(TABLE_USER,
                null,
                null,
                null,
                null,
                null,
                null);

        ArrayList<Login> loginArrayList = new ArrayList<>();
        if(cursor !=null)
        {
            if(cursor.getCount() > 0)
            {
                while (cursor.moveToNext())
                {
                    Login login = new Login();
                    login.setEmail(cursor.getString(0));
                    login.setPassword(cursor.getString(1));
                    loginArrayList.add(login);
                    Log.d("DB",login.getEmail() + " : " + login.getPassword());
                }
            }
        }
        database.close();

        return loginArrayList;

    }

    public boolean isValidUser(String email, String password) {
        dbHelper = new DBHelper(context);
        SQLiteDatabase database = dbHelper.getReadableDatabase();

        Cursor cursor = database.query(TABLE_USER,
                null,
                KEY_USER_EMAIL + "=? AND " + KEY_USER_PASSWORD + "=?",
                new String[]{email, password},
                null,
                null,
                null);

        if (cursor != null) {
            if (cursor.getCount() == 1) {
                return true;
            }
        }

        return false;
    }
}

