package com.d3ifcool.park_in.ImportantMethod;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rivkal Sanjaya
 *
 * =========================================
 * Park-In-master
 * Copyright (C) 26/03/2018.
 * All rights reserved
 * -----------------------------------------
 * Name     : Rivkal Sanjaya
 * E-mail   : sanjayarivkal@gmail.com
 * Majors   : D3 Teknik Informatika 2016
 * Campus   : Telkom University
 * -----------------------------------------
 *
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    // Deklarasi Nama Database dan Versinya ------------------
    private static final String DATABASE = "parkir.db";
    private static final int DATABASE_VERSION = 1;
    // -------------------------------------------------------

    // Deklarasi SQL Create dan Upgrade Table dalam bentuk variable string -------
    private String sql_drop_table;
    private String sql_create_table;
    // ---------------------------------------------------------------------------

    // Variable ini gunanya adalah untuk mendapatkan fungsi dari library SQLiteDatabase ---
    private SQLiteDatabase sqLiteDatabase = getWritableDatabase();
    // ada dua macam, "WriteableDatabase" dan "ReadableDatabase"

    private long result; // result ini untuk mendapatkan boolean dari insert data (true/false)

    // Variable projection ini gunanya untuk memilih column pada database
    // Guna variable projection ini sama seperti * pada SQL
    private String projection[] = {DataContract.DataEntry._ID,
            DataContract.DataEntry.COLUMN_TANGGAL,
            DataContract.DataEntry.COLUMN_WAKTU,
            DataContract.DataEntry.COLUMN_NAMA_TEMPAT,
            DataContract.DataEntry.COLUMN_KETERANGAN_TEMPAT,
            DataContract.DataEntry.COLUMN_FOTO
    };

    // ------------------------------------------------------------------------------------


    public DatabaseHelper(Context context) {
        super(context, DATABASE, null, DATABASE_VERSION);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            sql_create_table = "CREATE TABLE IF NOT EXISTS " + DataContract.DataEntry.TABLE_NAME + " (" +
                    DataContract.DataEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    DataContract.DataEntry.COLUMN_TANGGAL + " TEXT NOT NULL," +
                    DataContract.DataEntry.COLUMN_WAKTU + " TEXT NOT NULL," +
                    DataContract.DataEntry.COLUMN_NAMA_TEMPAT + " TEXT NOT NULL," +
                    DataContract.DataEntry.COLUMN_KETERANGAN_TEMPAT + " TEXT NOT NULL," +
                    DataContract.DataEntry.COLUMN_FOTO + " TEXT);";
            db.execSQL(sql_create_table);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // Insert Data dalam Database -------------------------------------------------------------------
    public boolean insertData(String tanggal, String waktu, String namaTempat, String keteranganTempat, String foto) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put(DataContract.DataEntry.COLUMN_TANGGAL, tanggal);
            contentValues.put(DataContract.DataEntry.COLUMN_WAKTU, waktu);
            contentValues.put(DataContract.DataEntry.COLUMN_NAMA_TEMPAT, namaTempat);
            contentValues.put(DataContract.DataEntry.COLUMN_KETERANGAN_TEMPAT, keteranganTempat);
            contentValues.put(DataContract.DataEntry.COLUMN_FOTO, foto);

            result = sqLiteDatabase.insert(DataContract.DataEntry.TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    // ----------------------------------------------------------------------------------------------

    // Method Cursor untuk menarik semua data sementara dari database -------------
    // dalam method ini menggambil semua data tanpa arguments
    public Cursor getAllData(){
        Cursor res = sqLiteDatabase.query(
                DataContract.DataEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                DataContract.DataEntry.COLUMN_TANGGAL
        );
        return res;
    }
    // ----------------------------------------------------------------------------



}
