package com.example.week2daily3animals;

public class AnimalDBConstants {
    public static final String DATABASE_NAME = "AnimalDB";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Animal";
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_TYPE ="type";
    public static final String FIELD_SOUND = "sound";
    public static final String FIELD_POP = "pop";
    public static final String FIELD_IMAGE = "image";

    //CREATE TABLE
    static final String createStmt = "CREATE TABLE " + TABLE_NAME + " ("
            + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + FIELD_NAME + " TEXT, "
            + FIELD_TYPE + " TEXT, "
            + FIELD_SOUND + " TEXT, "
            + FIELD_POP + " TEXT, "
            + FIELD_IMAGE + " TEXT)";

    //DROP TB
    static final String DROP_DB = "DRP TABLE IF EXISTS " + DATABASE_NAME;
}