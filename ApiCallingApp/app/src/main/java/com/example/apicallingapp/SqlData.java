package com.example.apicallingapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SqlData extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="user_db";
    public static final int DATABASE_VERSIAN =1;
    public static final String TABLE_USER ="user_info";
    public static final String USER_ID ="user_id";
    public static final String USER_NAME ="name";
    public static final String USER_USERNAME ="user_name";
    public static final String USER_EMAIL ="email";
    public static final String USER_PHONE ="phone";
    public static final String USER_WEBSITE ="website";
//    table2

    public static final String USER_STREET ="user_street";
    public static final String USER_SUITE ="user_suite";
    public static final String USER_CITY ="user_city";
    public static final String USER_ZIPCODE ="user_zipcode";
    //    table3

    public static final String USER_LATITUDE ="user_latitude";
    public static final String USER_LONGITUDE ="user_longitude";
    //    table3

    public static final String USER_COMPANY ="user_company";
    public static final String USER_CATCH_PHRASE ="user_catch_pharse";
    public static final String USER_BUSINESS_STRATEGIES ="user_bs";




    public SqlData( Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSIAN);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLE_USER+"("+
                USER_ID+" Integar PRIMARY kEY AUTOINCREMENT, "+
                USER_NAME+"TEXT NOT NULL,"+
                USER_USERNAME+"TEXT NOT NULL,"+
                USER_EMAIL+"TEXT UNIQUE"+
                USER_PHONE+"Integar NOT NULL,"+
                USER_WEBSITE+"TEXT NOT NULL,"+
                USER_STREET+"TEXT NOT NULL,"+
                USER_SUITE+"TEXT NOT NULL,"+
                USER_CITY+"TEXT NOT NULL,"+
                USER_LATITUDE+"TEXT NOT NULL,"+
                USER_LONGITUDE+"TEXT NOT NULL,"+
                USER_COMPANY+"TEXT NOT NULL,"+
                USER_CATCH_PHRASE+"TEXT NOT NULL,"+
                USER_BUSINESS_STRATEGIES+"TEXT NOT NULL"+")";
        sqLiteDatabase.execSQL(query);






    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_USER);
        onCreate(sqLiteDatabase);

    }

    //    insert

    public  void create_student_data(User user){
        SQLiteDatabase data =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(USER_ID,user.id);
        contentValues.put(USER_NAME,user.name);
        contentValues.put(USER_USERNAME,user.username);
        contentValues.put(USER_EMAIL,user.email);
        contentValues.put(USER_PHONE,user.phone);
        contentValues.put(USER_WEBSITE,user.website);
        contentValues.put(USER_STREET,user.street);
        contentValues.put(USER_SUITE,user.suite);
        contentValues.put(USER_CITY,user.city);
        contentValues.put(USER_LATITUDE,user.lat);
        contentValues.put(USER_LONGITUDE,user.lng);
        contentValues.put(USER_COMPANY,user.company_name);
        contentValues.put(USER_CATCH_PHRASE,user.catchPhrase);
        contentValues.put(USER_BUSINESS_STRATEGIES,user.bs);
        data.insert(TABLE_USER,null,contentValues);
        data.close();
    }

    //    fetch
    public ArrayList<User> ReadData(){
        ArrayList<User> students = new ArrayList<>();
        SQLiteDatabase read = this.getReadableDatabase();

        Cursor cursor = read.rawQuery("SELECT * FROM "+TABLE_USER,null);
        if(cursor.moveToFirst()){
            do{
                User user= new User(
                        cursor.getInt(cursor.getColumnIndexOrThrow(USER_ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_NAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_USERNAME)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_EMAIL)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_PHONE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_WEBSITE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_STREET)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_SUITE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_CITY)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_LATITUDE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_LONGITUDE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_COMPANY)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_CATCH_PHRASE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(USER_BUSINESS_STRATEGIES))
                );

              students.add(user);
            }while (cursor.moveToNext());

        }
        cursor.close();
        read.close();


        return students;
    }
}
