package com.faresa.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import com.faresa.myapplication.pojo.DataItem;
import com.google.android.material.textfield.TextInputLayout;

public class DetailActivity extends AppCompatActivity {
    TextView ktp,npwp,alamat,provinsi,kota,kecamatan,kelurahan,username,pemilik,nametoko,entitas,dc,kategori,telfon, keterangan, status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        DataItem item = getIntent().getParcelableExtra("data");

        username = findViewById(R.id.username);
        String User =item.getUsername();
        username.setText(User);

    }
}
