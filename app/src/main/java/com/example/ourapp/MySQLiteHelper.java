package com.example.ourapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    // Table names
    private final String TABLE_USERS;
    private final String TABLE_FORM1_DATA;
    private final String TABLE_FORM2_DATA;

    // Common column names
    private final String COLUMN_ID;

    // Users table columns
    private final String COLUMN_USERNAME;
    private final String COLUMN_PASSWORD;

    // Form1_data table columns
    private final String COLUMN_ROAD;
    private final String COLUMN_START;
    private final String COLUMN_END;
    private final String COLUMN_LINK;
    private final String COLUMN_SUBLINK;
    private final String COLUMN_REGION;
    private final String COLUMN_SHOULDERTYPE;

    // Form2_data table columns
    private final String COLUMN_SURVEYREF;
    private final String COLUMN_SURFACETYPE;
    private final String COLUMN_CARRIAGEWAYSHAPE;
    private final String COLUMN_CARRIAGEWAYSURFACE;
    private final String COLUMN_OVERALLCONDITION;
    private final String COLUMN_SPOTIMPROVEMENT;
    private final String COLUMN_LEFTDRAINAGE;
    private final String COLUMN_LEFTSPECIALDRAINAGE;
    private final String COLUMN_LEFTSLOPES;
    private final String COLUMN_RIGHTDRAINAGE;
    private final String COLUMN_RIGHTSPECIALDRAINAGE;
    private final String COLUMN_RIGHTSLOPES;
    private final String COLUMN_URGENT;
    private final String COLUMN_GRAVELTHICKNESS;
    private final String COLUMN_CULVERTSREPAIR;
    private final String COLUMN_CULVERTSNEW;
    private final String COLUMN_BRIDGESREPAIR;
    private final String COLUMN_BRIDGESNEW;
    private final String COLUMN_RIVERPROTECTION;
    private final String COLUMN_NOTES;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        // Initialize table names
        TABLE_USERS = context.getString(R.string.table_users);
        TABLE_FORM1_DATA = context.getString(R.string.table_form1_data);
        TABLE_FORM2_DATA = context.getString(R.string.table_form2_data);

        // Initialize common column names
        COLUMN_ID = context.getString(R.string.column_id);

        // Initialize Users table columns
        COLUMN_USERNAME = context.getString(R.string.column_username);
        COLUMN_PASSWORD = context.getString(R.string.column_password);

        // Initialize Form1_data table columns
        COLUMN_ROAD = context.getString(R.string.column_road);
        COLUMN_START = context.getString(R.string.column_start);
        COLUMN_END = context.getString(R.string.column_end);
        COLUMN_LINK = context.getString(R.string.column_link);
        COLUMN_SUBLINK = context.getString(R.string.column_sublink);
        COLUMN_REGION = context.getString(R.string.column_region);
        COLUMN_SHOULDERTYPE = context.getString(R.string.column_shouldertype);

        // Initialize Form2_data table columns
        COLUMN_SURVEYREF = context.getString(R.string.column_surveyref);
        COLUMN_SURFACETYPE = context.getString(R.string.column_surfacetype);
        COLUMN_CARRIAGEWAYSHAPE = context.getString(R.string.column_carriagewayshape);
        COLUMN_CARRIAGEWAYSURFACE = context.getString(R.string.column_carriagewaysurface);
        COLUMN_OVERALLCONDITION = context.getString(R.string.column_overallcondition);
        COLUMN_SPOTIMPROVEMENT = context.getString(R.string.column_spotimprovement);
        COLUMN_LEFTDRAINAGE = context.getString(R.string.column_leftdrainage);
        COLUMN_LEFTSPECIALDRAINAGE = context.getString(R.string.column_leftspecialdrainage);
        COLUMN_LEFTSLOPES = context.getString(R.string.column_leftslopes);
        COLUMN_RIGHTDRAINAGE = context.getString(R.string.column_rightdrainage);
        COLUMN_RIGHTSPECIALDRAINAGE = context.getString(R.string.column_rightspecialdrainage);
        COLUMN_RIGHTSLOPES = context.getString(R.string.column_rightslopes);
        COLUMN_URGENT = context.getString(R.string.column_urgent);
        COLUMN_GRAVELTHICKNESS = context.getString(R.string.column_gravelthickness);
        COLUMN_CULVERTSREPAIR = context.getString(R.string.column_culvertsrepair);
        COLUMN_CULVERTSNEW = context.getString(R.string.column_culvertsnew);
        COLUMN_BRIDGESREPAIR = context.getString(R.string.column_bridgesrepair);
        COLUMN_BRIDGESNEW = context.getString(R.string.column_bridgesnew);
        COLUMN_RIVERPROTECTION = context.getString(R.string.column_riverprotection);
        COLUMN_NOTES = context.getString(R.string.column_notes);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create users table
        String createUserTableQuery = "CREATE TABLE " + TABLE_USERS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_USERNAME + " TEXT, " +
                COLUMN_PASSWORD + " TEXT" +
                ")";
        db.execSQL(createUserTableQuery);

        // Create form1_data table
        String createForm1DataTableQuery = "CREATE TABLE " + TABLE_FORM1_DATA + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ROAD + " TEXT, " +
                COLUMN_START + " TEXT, " +
                COLUMN_END + " TEXT, " +
                COLUMN_LINK + " TEXT, " +
                COLUMN_SUBLINK + " TEXT, " +
                COLUMN_REGION + " TEXT, " +
                COLUMN_SHOULDERTYPE + " TEXT" +
                ")";
        db.execSQL(createForm1DataTableQuery);

        // Create form2_data table
        String createForm2DataTableQuery = "CREATE TABLE " + TABLE_FORM2_DATA + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_SURVEYREF + " TEXT, " +
                COLUMN_SURFACETYPE + " TEXT, " +
                COLUMN_CARRIAGEWAYSHAPE + " TEXT, " +
                COLUMN_CARRIAGEWAYSURFACE + " TEXT, " +
                COLUMN_OVERALLCONDITION + " TEXT, " +
                COLUMN_SPOTIMPROVEMENT + " TEXT, " +
                COLUMN_LEFTDRAINAGE + " TEXT, " +
                COLUMN_LEFTSPECIALDRAINAGE + " TEXT, " +
                COLUMN_LEFTSLOPES + " TEXT, " +
                COLUMN_RIGHTDRAINAGE + " TEXT, " +
                COLUMN_RIGHTSPECIALDRAINAGE + " TEXT, " +
                COLUMN_RIGHTSLOPES + " TEXT, " +
                COLUMN_URGENT + " INTEGER, " +
                COLUMN_GRAVELTHICKNESS + " TEXT, " +
                COLUMN_CULVERTSREPAIR + " TEXT, " +
                COLUMN_CULVERTSNEW + " TEXT, " +
                COLUMN_BRIDGESREPAIR + " TEXT, " +
                COLUMN_BRIDGESNEW + " TEXT, " +
                COLUMN_RIVERPROTECTION + " TEXT, " +
                COLUMN_NOTES + " TEXT" +
                ")";
        db.execSQL(createForm2DataTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if they exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FORM1_DATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FORM2_DATA);

        // Create tables again
        onCreate(db);
    }
}
