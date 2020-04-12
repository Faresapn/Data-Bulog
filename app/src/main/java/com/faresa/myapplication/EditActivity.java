package com.faresa.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.faresa.myapplication.pojo.DataItem;
import com.faresa.myapplication.pojo.GetData;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class EditActivity extends AppCompatActivity {
    TextInputLayout ktp,npwp,alamat,provinsi,kota,kecamatan,kelurahan,username,pemilik,nametoko,entitas,dc,kategori,telfon;
    Spinner keterangan, status;
    Button submit;
    DataItem dataGet;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        dataGet = getIntent().getParcelableExtra("data");
        ktp = findViewById(R.id.ktp);
        Objects.requireNonNull(ktp.getEditText()).setText(String.valueOf(dataGet.getKtp()));

        npwp = findViewById(R.id.npwp);
        Objects.requireNonNull(npwp.getEditText()).setText(String.valueOf(dataGet.getNpwp()));

        alamat = findViewById(R.id.alamat);
        Objects.requireNonNull(alamat.getEditText()).setText(String.valueOf(dataGet.getAlamat()));

        provinsi = findViewById(R.id.provinsi);
        Objects.requireNonNull(provinsi.getEditText()).setText(String.valueOf(dataGet.getProvinsi()));

        kota = findViewById(R.id.kota);
        Objects.requireNonNull(kota.getEditText()).setText(String.valueOf(dataGet.getKota()));

        kecamatan = findViewById(R.id.kecamatan);
        Objects.requireNonNull(kecamatan.getEditText()).setText(String.valueOf(dataGet.getKecamatan()));

        kelurahan = findViewById(R.id.kelurahan);
        Objects.requireNonNull(kelurahan.getEditText()).setText(String.valueOf(dataGet.getKelurahan()));

        username = findViewById(R.id.username);
        Objects.requireNonNull(username.getEditText()).setText(String.valueOf(dataGet.getUsername()));

        pemilik = findViewById(R.id.name);
        Objects.requireNonNull(pemilik.getEditText()).setText(String.valueOf(dataGet.getPemilik()));

        nametoko = findViewById(R.id.toko);
        Objects.requireNonNull(nametoko.getEditText()).setText(String.valueOf(dataGet.getToko()));

        entitas = findViewById(R.id.entitas);
        Objects.requireNonNull(entitas.getEditText()).setText(String.valueOf(dataGet.getEntitas()));

        dc = findViewById(R.id.dc);
        Objects.requireNonNull(dc.getEditText()).setText(String.valueOf(dataGet.getDc()));

        kategori = findViewById(R.id.kategori);
        Objects.requireNonNull(kategori.getEditText()).setText(String.valueOf(dataGet.getKategori()));

        telfon = findViewById(R.id.notelp);
        Objects.requireNonNull(telfon.getEditText()).setText(String.valueOf(dataGet.getTelfon()));

        keterangan = findViewById(R.id.spinner_aktif);
        status = findViewById(R.id.spinner_terima);

        ArrayAdapter<CharSequence> adapterBelt = ArrayAdapter.createFromResource(this,
                R.array.aktif, R.layout.spinner_items);
        adapterBelt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        keterangan.setAdapter(adapterBelt);
        keterangan.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                keterangan.getSelectedItem();
                final String ket = String.valueOf(keterangan.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter<CharSequence> adapterBe = ArrayAdapter.createFromResource(this,
                R.array.terima, R.layout.spinner_items);
        adapterBe.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        status.setAdapter(adapterBe);
        status.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                status.getSelectedItem();
                final String stats = String.valueOf(status.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
