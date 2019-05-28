package com.medikart.medikart;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "medimart.db";
    public static final String TABLE_NAME = "medicine";
    public static final String COLUMN_ID = "medicine_id";
    public static final String COLUMN_NAME = "medicine_name";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS "+ TABLE_NAME + "("+ COLUMN_ID+
                " INTEGER PRIMARY KEY, "+ COLUMN_NAME + " TEXT )";
        db.execSQL(CREATE_TABLE);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {}
    public String loadHandler(){
        String result = "";
        String query = "Select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        while(cursor.moveToNext()){
            int result_0 = cursor.getInt(0);
            String result_1 = cursor.getString(1);
            result += String.valueOf(result_0)+"    "+result_1+System.getProperty("line.separator");
        }
        cursor.close();
        db.close();
        return result;
    }
    public void addHandler(Medicine medicine){
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID,medicine.getId());
        values.put(COLUMN_NAME,medicine.getName());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_NAME,null,values);
        db.close();
    }
}
