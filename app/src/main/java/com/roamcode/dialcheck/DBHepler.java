package com.roamcode.dialcheck;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class DBHepler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Telecomunication";
    public static final String TABLE_AREAOPERATOR ="Area_Operator";
    public static final String Area_CODE_COLUMN= "Area_Codes";
    public static final String AREA_COLUMN = "Area";
    public static final String TABLE_CELLPHONENO= "Cellphone_No";
    public static final String  CELLPHONE_CODES_COLUMN = "Cell_Codes";
    public static final String  NETWORKS_COLUMN = "Networks";

    public DBHepler(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " +TABLE_AREAOPERATOR  + "("+ AREA_COLUMN + " TEXT PRIMARY KEY," + Area_CODE_COLUMN + " TEXT"+" )");

        db.execSQL("CREATE TABLE " +TABLE_CELLPHONENO  + "("+ CELLPHONE_CODES_COLUMN + " TEXT PRIMARY KEY," + NETWORKS_COLUMN + " TEXT"+")");

        Log.d(TAG, "Database tables created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_AREAOPERATOR);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CELLPHONENO);
        onCreate(db);

    }


   public void insertArea (String areacodes, String area) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Area_CODE_COLUMN, areacodes);
        contentValues.put(AREA_COLUMN, area);

        db.insert(TABLE_AREAOPERATOR, null, contentValues);
       Log.d(TAG, "New Data inserted into sqlite ");
    }

    public void insertNetwork (String Cellcodes, String networks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CELLPHONE_CODES_COLUMN, Cellcodes);
        contentValues.put(NETWORKS_COLUMN, networks);

        db.insert(TABLE_CELLPHONENO  , null, contentValues);
        Log.d(TAG, "New Data inserted into sqlite ");
    }

  /*  public Cursor getData(String CellCode) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_CELLPHONENO+" where CellCodes = ?",  new String[]{CellCode} );
        return res;
    }*/




}
