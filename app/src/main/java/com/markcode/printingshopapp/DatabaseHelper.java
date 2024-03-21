package com.markcode.printingshopapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String TBL_REGISTER = "TBL_REGISTER";
    public static final String ID = "ID";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";
    public static final String FIRSTNAME = "FIRSTNAME";
    public static final String LASTNAME = "LASTNAME";
    public static final String AGE = "AGE";
    public static final String BIRTHDATE = "BIRTHDATE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "printing.db ", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlLiteDataBase) {
        String SQL_CreateRegisterTB = "CREATE TABLE " + TBL_REGISTER + " (" + ID +" INTEGER" + " PRIMARY KEY AUTOINCREMENT , " + USERNAME + " TEXT, " + PASSWORD + " TEXT, " + FIRSTNAME + " TEXT, " + LASTNAME + " TEXT, " + AGE + " INT, " + BIRTHDATE + " TEXT )";
        sqlLiteDataBase.execSQL(SQL_CreateRegisterTB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean RegisterUser (RegisterModel registerModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(USERNAME,registerModel.getUserName());
        cv.put(PASSWORD,registerModel.getPassword());
        cv.put(FIRSTNAME,registerModel.getFirstName());
        cv.put(LASTNAME, registerModel.getLastName());
        cv.put(AGE, registerModel.getAge());
        cv.put(BIRTHDATE,registerModel.getBirthDate());


        long insert = db.insert(TBL_REGISTER,null, cv);

        if(insert == -1) {

            return false;
        }
        else
        {
            return true;
        }



    }

    public List<RegisterModel> getAllUsernamePassword()
    {
        List<RegisterModel> returnList = new ArrayList<>();

        String queryString = "SELECT "+USERNAME+","+PASSWORD+" FROM "+TBL_REGISTER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null );


        if(cursor.moveToFirst())
        {

            do{
                String UserName = cursor.getString(0);
                String Password = cursor.getString(1);
                RegisterModel newRefister = new RegisterModel(UserName,Password );
                returnList.add(newRefister);
            }while (cursor.moveToNext());

        }
        else
        {}

        db.close();
        cursor.close();
        return returnList;

    }

    public List<RegisterModel> getAllUserName()
    {

        List<RegisterModel> returnUserNames = new ArrayList<>();

        String queryString = "SELECT "+USERNAME+" FROM "+TBL_REGISTER;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);


        if(cursor.moveToFirst())
        {
            do{

                String UserName = cursor.getString(0);
                RegisterModel registerModel = new RegisterModel();
                registerModel.setUserName(UserName);
                returnUserNames.add(registerModel);

            }while(cursor.moveToNext());

        }

        db.close();
        cursor.close();
        return returnUserNames;

    }


}
