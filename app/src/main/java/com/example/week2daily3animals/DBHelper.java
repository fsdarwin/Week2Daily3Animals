package com.example.week2daily3animals;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    int count;
    public static final String TAG = "FRANK: ";
    Context context;
    SQLiteDatabase sqldb;
    DBHelper helper;


    public DBHelper(Context context) {
        super(context, AnimalDBConstants.DATABASE_NAME, null, AnimalDBConstants.DATABASE_VERSION);
        //this.context = context;
        //helper=new DBHelper(context);
    }

    @Override
    public void onCreate(SQLiteDatabase sqldb) {
        try {
            sqldb.execSQL(AnimalDBConstants.createStmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqldb, int oldVersion, int newVersion) {
        sqldb.execSQL(AnimalDBConstants.DROP_DB);
        onCreate(sqldb);
    }

    public DBAnimal selectAnimal(String animalId) {
        DBAnimal returnDBAnimal = null;//Set return value to null
        if (animalId != null && !animalId.isEmpty()) {//IF the value passed in is not null
            SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();//OPEN database for read only
            //SELECT by animal id
            String query = "SELECT * FROM " + AnimalDBConstants.TABLE_NAME + " WHERE " + AnimalDBConstants.FIELD_ID + " = \"" + animalId + "\"";
            //Create a cursor to store the record(s)
            Cursor cursor = sqLiteDatabase.rawQuery(query, null);
            //If a record was returned./..
            if (cursor.moveToFirst()) {
                //Store the record into an Animal object
                int id = cursor.getInt(cursor.getColumnIndex(AnimalDBConstants.FIELD_ID));
                String name = cursor.getString(cursor.getColumnIndex(AnimalDBConstants.FIELD_NAME));
                String type = cursor.getString(cursor.getColumnIndex(AnimalDBConstants.FIELD_TYPE));
                String sound = cursor.getString(cursor.getColumnIndex(AnimalDBConstants.FIELD_SOUND));
                String pop = cursor.getString(cursor.getColumnIndex(AnimalDBConstants.FIELD_POP));
                String image = cursor.getString(cursor.getColumnIndex(AnimalDBConstants.FIELD_IMAGE));
                Animal animal = new Animal(name, type, sound, image);
                returnDBAnimal = new DBAnimal(id, animal);
            }//Close the cursor
            cursor.close();
        }//return the Animal object
        return returnDBAnimal;
    }

    public ArrayList<DBAnimal> selectAllAnimals() {
        //Get readable instance of database
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        //Select all
        String query = "SELECT * FROM " + AnimalDBConstants.TABLE_NAME;
        //Create cursor to store the records returned
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        //If records were returned...
        if (cursor.moveToFirst()) {
            //Create an array list to store the records
            ArrayList<DBAnimal> arrayList = new ArrayList<>();
            //Cycle through the cursor
            do {
                int id = cursor.getInt(cursor.getColumnIndex(AnimalDBConstants.FIELD_ID));
                String name = cursor.getString(cursor.getColumnIndex(AnimalDBConstants.FIELD_NAME));
                String type = cursor.getString(cursor.getColumnIndex(AnimalDBConstants.FIELD_TYPE));
                String sound = cursor.getString(cursor.getColumnIndex(AnimalDBConstants.FIELD_SOUND));
                String pop = cursor.getString(cursor.getColumnIndex(AnimalDBConstants.FIELD_POP));
                String image = cursor.getString(cursor.getColumnIndex(AnimalDBConstants.FIELD_IMAGE));
                Animal animal = new Animal(name, type, sound, image);
                Log.d(TAG, "INSERT: " + animal.getName() + ", " + animal.getType() + ", " + animal.getSound() + ", " + animal.getPop());
                //Add the record to the array list
                arrayList.add(new DBAnimal(id, animal));
            } while (cursor.moveToNext());
            //Close the cursor
            cursor.close();
            //return the array list
            return arrayList;
        } else {
            return null;
        }
    }

    //Insert a new animal
    public void insertAnimal(Animal animal) {
        SQLiteDatabase database = this.getReadableDatabase();//Get writable instance of database
        ContentValues contentValues = new ContentValues();//Create a new content values to store the fields

        if (animal != null) {//As long as the passed in animal was not null...
            String name = animal.getName();//Get the fields from the Animal object
            String type = animal.getType();
            String sound = animal.getSound();
            String pop = animal.getPop();
            String image = animal.getImage();

            contentValues.put(AnimalDBConstants.FIELD_NAME, name);//Put those fields into the content values object
            contentValues.put(AnimalDBConstants.FIELD_TYPE, type);
            contentValues.put(AnimalDBConstants.FIELD_SOUND, sound);
            contentValues.put(AnimalDBConstants.FIELD_POP, pop);
            contentValues.put(AnimalDBConstants.FIELD_IMAGE, image);
            //Update the table with the new record.
            database.insert(AnimalDBConstants.TABLE_NAME, null, contentValues);
        }
    }

    //Update an animal type by id
    public int updateAnimal(DBAnimal dbAnimal) {
        if (dbAnimal != null) {//As long as the passed in animal was not null...
            //Find the record to update with the id
            String whereClause = AnimalDBConstants.FIELD_ID + " = \"" + dbAnimal.getId() + "\"";
            //Get writable instance of the database
            SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
            //New content values to store the fields
            ContentValues contentValues = new ContentValues();
            //Put the fields into the content values
            contentValues.put(AnimalDBConstants.FIELD_ID, dbAnimal.getId());
            contentValues.put(AnimalDBConstants.FIELD_NAME, dbAnimal.getAnimal().getName());
            contentValues.put(AnimalDBConstants.FIELD_TYPE, dbAnimal.getAnimal().getType());
            contentValues.put(AnimalDBConstants.FIELD_SOUND, dbAnimal.getAnimal().getSound());
            contentValues.put(AnimalDBConstants.FIELD_POP, dbAnimal.getAnimal().getPop());
            contentValues.put(AnimalDBConstants.FIELD_IMAGE, dbAnimal.getAnimal().getImage());
            //Update the record
            return sqLiteDatabase.update(AnimalDBConstants.TABLE_NAME, contentValues, whereClause, null);
        } else {
            return 0;
        }
    }

    //Delete an animal type by id
    public boolean deleteAnimal(int id) {
        //Find record by id
        String whereClause = AnimalDBConstants.FIELD_ID + " = \"" + id + "\"";
        //get writable instance of database
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        //Delete record by id
        try {
            if (sqLiteDatabase.delete(AnimalDBConstants.TABLE_NAME, whereClause, null) > 0) {
                return true;
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //Setter for count
    public void setCount(int count) {
        this.count = count;
    }

    //Getter for count
    public int getCount() {
        return count;
    }
}
