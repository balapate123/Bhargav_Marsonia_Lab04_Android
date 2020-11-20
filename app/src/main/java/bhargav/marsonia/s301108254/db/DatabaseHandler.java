package bhargav.marsonia.s301108254.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import bhargav.marsonia.s301108254.model.BhargavPatient;
import bhargav.marsonia.s301108254.model.BhargavPatientData;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "bhargav_patient_management";

    private static final String CREATE_TABLE_PATIENT = "CREATE TABLE IF NOT EXISTS `bhargav_patient` ( `id`	INTEGER," +
            "`first_name`	TEXT,`last_name`	TEXT,`department`	TEXT)";
    Context context;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PATIENT);
    }

    @Override
    public synchronized void close() {
        super.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);


        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {

    }

    public void addPatient(BhargavPatient data) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("first_name", data.getFirst_name());
        values.put("last_name", data.getLast_name());
        values.put("department", data.getDepartment_name());


        db.insert("bhargav_patient", null, values);
        db.close();
    }

    public List<String> getPatient() {
        try {
            List<String> patient = new ArrayList<String>();
            String query = "select * from bhargav_patient";
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery(query, null);

            if (cursor.moveToFirst()) {
                do {
                    patient.add(cursor.getString(cursor.getColumnIndex("first_name")));
                } while (cursor.moveToNext());
            }
            cursor.close();
            db.close();
            return patient;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
