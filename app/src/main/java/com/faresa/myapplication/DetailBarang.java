package com.faresa.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.faresa.myapplication.pojo.getbarang.GetBarang;

public class DetailBarang extends AppCompatActivity {
    TextView nama,harga,stok,ket,Jumlah,plus,minus;
    GetBarang barang;
    private int mCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_barang);

        barang = getIntent().getParcelableExtra("data");

        nama = findViewById(R.id.Nama);
        String Nama =barang.getNama();
        nama.setText(Nama);

        harga = findViewById(R.id.Harga);
        String Harga =String.valueOf(barang.getHarga());
        harga.setText(Harga);

        stok = findViewById(R.id.Stok);
        String Tok =String.valueOf(barang.getStok());
        stok.setText(Tok);

        ket = findViewById(R.id.Ket);
        String Ent = barang.getKeterangan();
        ket.setText(Ent);

        Jumlah = findViewById(R.id.jumlah);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountUp();
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDown();
            }
        });

    }
    public void CountUp() {
        mCount++;
        if ( Jumlah != null)
            Jumlah.setText(String.valueOf(mCount));

    }

    public void CountDown() {
        int x = Integer.valueOf(Jumlah.getText().toString());
        if (x > 0){
            int y = x - 1;
            Jumlah.setText(String.valueOf(y));
        }

    }

}
