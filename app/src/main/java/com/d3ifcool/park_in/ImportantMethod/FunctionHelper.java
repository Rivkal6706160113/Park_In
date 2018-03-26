package com.d3ifcool.park_in.ImportantMethod;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Faisal Amir
 * FrogoBox Inc License
 * =========================================
 * Park-In-master
 * Copyright (C) 26/03/2018.
 * All rights reserved
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : f.miir117@gmail.com
 * Line     : bullbee117
 * Phone    : 081357108568
 * Majors   : D3 Teknik Informatika 2016
 * Campus   : Telkom University
 * -----------------------------------------
 * id.amirisback.frogobox
 */

public class FunctionHelper {

        // Requirement Tanggal dan Waktu ---------------------------------
        private String dateToday;
        private Calendar currentTime;
        private String outputStringTime;
        private int systemJam, systemMenit, systemDetik, sumWaktuDetik;
        private String nilai_jam, nilai_menit, nilai_detik;
        private final int jamKeDetik = 3600;
        private final int menitKeDetik = 60;
        private final int detikKeMili = 1000;
        // ---------------------------------------------------------------

        public FunctionHelper() {
            this.currentTime = Calendar.getInstance();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMMM yyyy");
            this.dateToday = simpleDateFormat.format(currentTime.getTime());
            getSystemTime();
        }

        public String getDateToday() {
            return dateToday;
        }

        public String getOutputStringTime() {
            outputStringTime = nilai_jam + ":" + nilai_menit + ":" + nilai_detik;
            return outputStringTime;
        }

        public void getSkalaWaktu24() {
            // Skala Waktu 24 Jam ---------------------------------------------------------------
            Calendar cal = Calendar.getInstance();
            systemJam = cal.get(Calendar.HOUR_OF_DAY);
            systemMenit = cal.get(Calendar.MINUTE);
            systemDetik = cal.get(Calendar.SECOND);
            // ----------------------------------------------------------------------------------
        }

        public void getSystemTime() {
            getSkalaWaktu24(); // skala waktu 24 Jam
            // Jika waktu itu kurang dari 9 maka akan di tambahkan 0 didepan angkanya -----------
            String nol_jam = "", nol_menit = "",nol_detik = "";
            if(systemJam <= 9)
                nol_jam= "0";
            if(systemMenit <= 9)
                nol_menit= "0";
            if(systemDetik <= 9)
                nol_detik= "0";
            // ----------------------------------------------------------------------------------

            // Tampilan String dari systemJam, systemMenit, systemDetik Ex : 02 , 05 , 15 -------
            nilai_jam = nol_jam + Integer.toString(systemJam);
            nilai_menit = nol_menit + Integer.toString(systemMenit);
            nilai_detik = nol_detik + Integer.toString(systemDetik);
            // ----------------------------------------------------------------------------------
        }


}
