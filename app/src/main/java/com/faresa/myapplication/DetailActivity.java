package com.faresa.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import com.faresa.myapplication.pojo.DataItem;
import com.google.android.material.textfield.TextInputLayout;

public class DetailActivity extends AppCompatActivity {
    TextView ktp,npwp,alamat,provinsi,kota,kecamatan,kelurahan,username,pemilik,nametoko,entitas,dc,kategori,telfon, keterangan, status;
    DataItem item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        item = getIntent().getParcelableExtra("data");

        username = findViewById(R.id.User);
        String User =item.getUsername();
        username.setText(User);

        pemilik = findViewById(R.id.Pemilik);
        String Pem =item.getPemilik();
        pemilik.setText(Pem);

        nametoko = findViewById(R.id.Toko);
        String Tok =item.getToko();
        nametoko.setText(Tok);

        entitas = findViewById(R.id.Entitas);
        String Ent = item.getEntitas();
        entitas.setText(Ent);

        dc = findViewById(R.id.DC);
        String Dc = item.getDc();
        dc.setText(Dc);

        kategori = findViewById(R.id.Kategori);
        String Kt = item.getKategori();
        kategori.setText(Kt);

        ktp = findViewById(R.id.Ktp);
        String KtP = String.valueOf(item.getKtp());
        ktp.setText(KtP);

        npwp = findViewById(R.id.NPWP);
        String NP = item.getNpwp();
        npwp.setText(NP);

        alamat = findViewById(R.id.Almt);
        String AL = item.getAlamat();
        alamat.setText(AL);

        provinsi = findViewById(R.id.Prov);
        String Prov = item.getProvinsi();
        provinsi.setText(Prov);

        kota = findViewById(R.id.Kot);
        String Kot = item.getKota();
        kota.setText(Kot);

        kecamatan = findViewById(R.id.Kec);
        String kec = item.getKecamatan();
        kecamatan.setText(kec);

        kelurahan = findViewById(R.id.Kel);
        String Kel = item.getKelurahan();
        kelurahan.setText(Kel);

        telfon = findViewById(R.id.Telp);
        String Telp = String.valueOf(item.getTelfon());
        telfon.setText(Telp);

        keterangan = findViewById(R.id.KET);
        String KETe = item.getKeterangan();
        keterangan.setText(KETe);

        status = findViewById(R.id.St);
        String STA = item.getStatus();
        status.setText(STA);
    }
}
