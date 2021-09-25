package com.example.mad_mini_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class MydatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "hospitalDB.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "PatientsLog";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_CONTACT = "contact";
    private static final String COLUMN_WARD = "ward";

    private static final String TABLE_NAME1 = "my_library";
    private static final String COLUMN_ID2 = "_id";
    private static final String COLUMN_NAME2 = "name";
    private static final String COLUMN_DOSE = "dose";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_QUANTITY = "quantity";


    MydatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Patient database
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CONTACT + " TEXT, " +
                COLUMN_WARD + " INTEGERE);";
        db.execSQL(query);

        //Doctor database
        String query2 = "CREATE TABLE " + TABLE_NAME1 +
                " (" + COLUMN_ID2 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME2 + " TEXT, " +
                COLUMN_DOSE + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_QUANTITY + " INTEGER);";
        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //patient table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

        //DOctor table
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        onCreate(db);
    }

        //add patients
    void addPatient(String name, String contact, int ward) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        //Patient data insert
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_CONTACT, contact);
        cv.put(COLUMN_WARD, ward);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to insert!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Recorded Successfully!!", Toast.LENGTH_SHORT).show();
        }

    }

    //add doctors
    void addDrugs(String name, String dose, String description, int qyt){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME2, name);
        cv.put(COLUMN_DOSE, dose);
        cv.put(COLUMN_DESCRIPTION, description);
        cv.put(COLUMN_QUANTITY, qyt);
        long result = db.insert(TABLE_NAME1,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    //read patient data
    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    //read doctor data
    Cursor readAllDataD() {
        String query = "SELECT * FROM " + TABLE_NAME1;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    //update patient data
    void updateData(String raw_id, String name, String contact, String ward) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_CONTACT, contact);
        cv.put(COLUMN_WARD, ward);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{raw_id});
        if (result == -1) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Updated..", Toast.LENGTH_SHORT).show();
        }
    }
    //update doctors data
    void updateDataD(String row_id, String name, String dose, String description, String quantity){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME2, name);
        cv.put(COLUMN_DOSE, dose);
        cv.put(COLUMN_DESCRIPTION, description);
        cv.put(COLUMN_QUANTITY, quantity);

        long result = db.update(TABLE_NAME1, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Update", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Successfully Updated!", Toast.LENGTH_SHORT).show();
        }

    }

    //patient delete one row
    void deleteOneRaw(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});

        if (result == -1) {
            Toast.makeText(context, "Failed to delete!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully deleted!!", Toast.LENGTH_SHORT).show();
        }
    }
    //doctor delete one row
    void deleteOneRawD(String row_id) {
        SQLiteDatabase db = this.getWritableDatabase();

        long result = db.delete(TABLE_NAME1, "_id=?", new String[]{row_id});

        if (result == -1) {
            Toast.makeText(context, "Failed to delete!!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully deleted!!", Toast.LENGTH_SHORT).show();
        }
    }

    //delete all patient data
    void deleteAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME);
    }
    //delete all doctor data
    void deleteAllDataD() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME1);
    }
}

