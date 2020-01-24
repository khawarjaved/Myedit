package com.example.myedit;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqLiteDB extends SQLiteOpenHelper {
    SQLiteDatabase db;

    //database name
    private static final String DATABASE_NAME="Student_info";
    //database version
    private static final int DATABASE_VIRSION=1;
    //database table name
    private static final String TABLE_STUDENT="tblstudent";
    //database table column
    public static final String KEY_ROWID="id";
    public static final String KEY_FIRST_NAME="firstname";
    public static final String KEY_LAST_NAME="lastname";


    public SqLiteDB(@Nullable Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VIRSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_STUDENT_TABLE=" CREATE TABLE " + TABLE_STUDENT + "(" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                KEY_FIRST_NAME  +  "  TEXT, " + KEY_LAST_NAME + " TEXT); ";
        db.execSQL(CREATE_STUDENT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_STUDENT);
        onCreate(db);

    }

    public long insertStudent(String firstname, String lastnamae) {

        db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(KEY_FIRST_NAME, firstname);
        cv.put(KEY_LAST_NAME, lastnamae);
        return db.insert(TABLE_STUDENT, null, cv);
    }

    public String getData() {
        db=this.getReadableDatabase();
        String[] coulmns = new String[]{KEY_ROWID,KEY_FIRST_NAME,KEY_LAST_NAME};
        Cursor cursor=db.query(TABLE_STUDENT,coulmns,null,null,null,null,null);
        String result="";

        int iRow=cursor.getColumnIndex(KEY_ROWID);
        int ifirstname=cursor.getColumnIndex(KEY_FIRST_NAME);
        int ilastname=cursor.getColumnIndex(KEY_LAST_NAME);

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext());
        {
            result = result + cursor.getString(iRow) + "" + cursor.getString(ifirstname) + "" + cursor.getString(ilastname)+"\n";
        }
        return result;
    }
}
