package com.d3ifcool.park_in;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.d3ifcool.park_in.ImportantMethod.DatabaseHelper;
import com.d3ifcool.park_in.ImportantMethod.FunctionHelper;

public class tambahPark extends AppCompatActivity {

    // Deklarasi element layout
    ImageView imageView;
    Button btn_tambah;
    EditText edt_tempat, edt_keterangan;

    // Deklarasi Class bikinnan sendiri
    DatabaseHelper myDb;
    FunctionHelper functionHelper = new FunctionHelper();

    // Deklarasi Requirement Variable
    private String cekid;
    private String isi_namaTempat, isi_tanggal, isi_waktu, isi_ketaranganTempat, isi_foto;


    public boolean isEmpty(){
        return edt_tempat.getText().toString().equals("") || edt_keterangan.getText().toString().equals("");
    }


    // Method langsung isi dalam database ----------------------------------------------------------
    public void insertDataToDatabase() {
        boolean isInserted = myDb.insertData(isi_tanggal, isi_waktu, isi_namaTempat, isi_ketaranganTempat, isi_foto);
        if (isInserted) {
            Toast.makeText(this, "Data Parkir Masuk", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Data Not Inserted", Toast.LENGTH_LONG).show();
        }
    }
    // ---------------------------------------------------------------------------------------------


    public void addData(){
        if(!isEmpty()){
            insertDataToDatabase();
            Intent intent = new Intent(tambahPark.this, MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Tempat dan Keterangan tidak boleh kosong", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_park);

        imageView = findViewById(R.id.btn_img_foto);
        btn_tambah = findViewById(R.id.btn_tambah);
        edt_tempat = findViewById(R.id.edit_tempat);
        edt_keterangan = findViewById(R.id.edit_ket);


        isi_tanggal = functionHelper.getDateToday();
        isi_waktu = functionHelper.getOutputStringTime();
        isi_namaTempat = edt_tempat.getText().toString();
        isi_ketaranganTempat = edt_keterangan.getText().toString();
        isi_foto = "Foto";

        myDb = new DatabaseHelper(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });

        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();

            }
        });


    }
        @Override
        public void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);

    }



}
