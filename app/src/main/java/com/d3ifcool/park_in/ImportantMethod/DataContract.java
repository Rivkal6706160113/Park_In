package com.d3ifcool.park_in.ImportantMethod;

import android.provider.BaseColumns;

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

public class DataContract {
    // Class ini tujuannya untuk menjadi object table
    private DataContract() {
    }

    public static final class DataEntry implements BaseColumns {
        public static final String TABLE_NAME = "data_parkir"; // Dekldarasi Nama Table
        public static final String _ID  = BaseColumns._ID; // Dekalarasi ID
        public static final String COLUMN_TANGGAL = "tanggal";
        public static final String COLUMN_WAKTU = "waktu";
        public static final String COLUMN_NAMA_TEMPAT = "nama_tempat";
        public static final String COLUMN_KETERANGAN_TEMPAT = "keterangan_tempat";
        public static final String COLUMN_FOTO = "foto";
    }



}
