package com.hackathon.csi.myapp;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class sqllite extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "databasename.db";
    public static final String TABLE_NAME = "Tsbl";
    public static String COL1 = "ID";
    public static String COL2 = "TEAMNAME";
    public static String COL3 = "TeamMembers";
    public static String COL4 = "ProjectName";
    public static String COL5 = "Description";
    public static String COL6 = "StartUpYear";
    public static String COL7 = "Email";
    public static String COL8 = "Password";
    boolean b;

    public sqllite(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, TEAMNAME TEXT, TeamMembers TEXT , " +
                "ProjectName TEXT , Description TEXT,StartUpYear TEXT,Email TEXT,Password Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public boolean insertdata(String Teamname, String Teammembers, String projectname, String desc, String startup, String email, String Password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        //contentValues.put(COL2, Teamname);
        contentValues.put(COL3, Teammembers);
        contentValues.put(COL4, projectname);
        contentValues.put(COL5, desc);
        contentValues.put(COL6, startup);
        contentValues.put(COL7, email);
        contentValues.put(COL8, Password);
        long res = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (res == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor res = sqLiteDatabase.rawQuery(" select * from " + TABLE_NAME, null);
        return res;
    }
}
