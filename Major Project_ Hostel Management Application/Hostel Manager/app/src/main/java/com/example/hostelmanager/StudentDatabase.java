package com.example.hostelmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class StudentDatabase extends SQLiteOpenHelper {

    public static final String databaseName = "StudentsData.db";
    public StudentDatabase (@Nullable Context context) {
        super(context, "StudentsData.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("create Table students(name TEXT, fname TEXT, phone TEXT, email TEXT, year TEXT, dept TEXT, roll TEXT primary key, floor TEXT, room TEXT, dates TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists students");
    }
    public Boolean insertData(String name , String fname, String phone, String email, String year, String dept, String roll, String floor, String room, String date){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("fname", fname);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("year", year);
        contentValues.put("dept", dept);
        contentValues.put("roll", roll);
        contentValues.put("floor", floor);
        contentValues.put("room", room);
        contentValues.put("dates", date);
        long result = MyDatabase.insert("students", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Boolean checkDetails(String roll){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from students where roll = ?", new String[]{roll});
        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean updateData (String name , String fname, String phone, String email, String year, String dept, String roll, String floor, String room, String date){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from students where roll = ?", new String[]{roll});
        if(cursor.getCount() > 0) {
            MyDatabase.execSQL("UPDATE students SET name = '"+ name +"', fname = '"+ fname +"', phone = '"+ phone +"', email = '"+ email +"', year = '"+ year +"', dept = '"+ dept +"', roll = '"+ roll +"', floor = '"+ floor +"', room = '"+ room +"', dates = '"+ date +"' where roll = '"+roll+"'");
            return true;
        }else {
            return false;
        }
    }

    public int countData(){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select COUNT(*) from students", null);
        cursor.moveToFirst();
        int count = cursor.getInt(0);
        return count;
    }
    public Boolean deleteData(String roll){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Delete from students where roll = ?", new String[]{roll});
        if(cursor.getCount() == 0) {
            return true;
        }else {
            return false;
        }
    }

    public StringBuffer allDetails(){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from students", null );
        StringBuffer buf = new StringBuffer();
        if(cursor.getCount() == 0) {
            buf.append("No Data Found !!");
            return buf;
        }else {
            while(cursor.moveToNext()){
                buf.append("Name : "+cursor.getString(0)+"\n");
                buf.append("Guardian : "+cursor.getString(1)+"\n");
                buf.append("Phone : "+cursor.getString(2)+"\n");
                buf.append("Email : "+cursor.getString(3)+"\n");
                buf.append("Year : "+cursor.getString(4)+"\n");
                buf.append("Department : "+cursor.getString(5)+"\n");
                buf.append("Roll No : "+cursor.getString(6)+"\n");
                buf.append("Floor : "+cursor.getString(7)+"\n");
                buf.append("Room : "+cursor.getString(8)+"\n");
                buf.append("Allotment Date : "+cursor.getString(9)+"\n\n\n");
            }
            return buf;
        }
    }

    public String[] getDetails(String roll){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from students where roll = ?", new String[]{roll});
        String[] details = new String[10];
        while(cursor.moveToNext()){
            details[0] = cursor.getString(0);
            details[1] = cursor.getString(1);
            details[2] = cursor.getString(2);
            details[3] = cursor.getString(3);
            details[4] = cursor.getString(4);
            details[5] = cursor.getString(5);
            details[6] = cursor.getString(6);
            details[7] = cursor.getString(7);
            details[8] = cursor.getString(8);
            details[9] = cursor.getString(9);

        }
        return details;

    }
}
