package com.faresa.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.faresa.myapplication.connection.Client;
import com.faresa.myapplication.connection.Service;
import com.faresa.myapplication.pojo.GetData;
import com.faresa.myapplication.pojo.create.CreateResponse;
import com.google.android.material.textfield.TextInputLayout;

import java.util.jar.JarEntry;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateActivity extends AppCompatActivity {
    TextInputLayout ktp,npwp,alamat,provinsi,kota,kecamatan,kelurahan,username,pemilik,nametoko,entitas,dc,kategori,telfon;
    Spinner keterangan, status;
    Button submit;
    GetData dataGet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        ktp = findViewById(R.id.ktp);
        npwp = findViewById(R.id.npwp);
        alamat = findViewById(R.id.alamat);
        provinsi = findViewById(R.id.provinsi);
        kota = findViewById(R.id.kota);
        kecamatan = findViewById(R.id.kecamatan);
        kelurahan = findViewById(R.id.kelurahan);
        username = findViewById(R.id.username);
        pemilik = findViewById(R.id.name);
        nametoko = findViewById(R.id.toko);
        entitas = findViewById(R.id.entitas);
        dc = findViewById(R.id.dc);
        kategori = findViewById(R.id.kategori);
        telfon = findViewById(R.id.notelp);
        keterangan = findViewById(R.id.spinner_aktif);
        status = findViewById(R.id.spinner_terima);
        dataGet = getIntent().getParcelableExtra("data");
        //button
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
        submit = findViewById(R.id.save);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = username.getEditText().getText().toString().trim();
                String nama = pemilik.getEditText().getText().toString().trim();
                String Namatoko = nametoko.getEditText().getText().toString().trim();
                String Alamat = alamat.getEditText().getText().toString().trim();
                String Provinsi = provinsi.getEditText().getText().toString().trim();
                String Kota = kota.getEditText().getText().toString().trim();
                String Kecamatan = kecamatan.getEditText().getText().toString().trim();
                String Kelurahan = kelurahan.getEditText().getText().toString().trim();
                String Entitas = entitas.getEditText().getText().toString().trim();
                String Kategori = kategori.getEditText().getText().toString().trim();
                String Dc = dc.getEditText().getText().toString().trim();
                String NPWP = npwp.getEditText().getText().toString().trim();
                String KTP = ktp.getEditText().getText().toString().trim();
                int noTelp = Integer.parseInt(telfon.getEditText().getText().toString().trim());
                String Status = String.valueOf(status.getSelectedItem().toString().trim());
                String Ket = String.valueOf(keterangan.getSelectedItem().toString().trim());

                RequestBody requestUser = RequestBody.create(Username, MediaType.parse("multipart/form-data"));
                RequestBody requestName = RequestBody.create(nama, MediaType.parse("multipart/form-data"));
                RequestBody requestToko = RequestBody.create(Namatoko, MediaType.parse("multipart/form-data"));
                RequestBody requestAlamat = RequestBody.create(Alamat, MediaType.parse("multipart/form-data"));
                RequestBody requestProvinsi = RequestBody.create(Provinsi, MediaType.parse("multipart/form-data"));
                RequestBody requestKota = RequestBody.create(Kota, MediaType.parse("multipart/form-data"));
                RequestBody requestKec = RequestBody.create(Kecamatan, MediaType.parse("multipart/form-data"));
                RequestBody requestKel = RequestBody.create(Kelurahan, MediaType.parse("multipart/form-data"));
                RequestBody requestEnt = RequestBody.create(Entitas, MediaType.parse("multipart/form-data"));
                RequestBody requestKate = RequestBody.create(Kategori, MediaType.parse("multipart/form-data"));
                RequestBody requestDC = RequestBody.create(Dc, MediaType.parse("multipart/form-data"));
                RequestBody requestNPWP = RequestBody.create(NPWP, MediaType.parse("multipart/form-data"));
                RequestBody requestKtp = RequestBody.create(KTP, MediaType.parse("multipart/form-data"));
                RequestBody requestNotelp = RequestBody.create(String.valueOf(noTelp), MediaType.parse("multipart/form-data"));
                RequestBody requestStatus = RequestBody.create(status.getSelectedItem().toString().trim(), MediaType.parse("multipart/form-data"));
                RequestBody requestKet = RequestBody.create(keterangan.getSelectedItem().toString().trim(), MediaType.parse("multipart/form-data"));



                try {


                Service service = Client.getClient().create(Service.class);



                    Call<CreateResponse> create = service.createData(requestKtp, requestNPWP, requestAlamat, requestProvinsi, requestKota
                            , requestKec, requestKel, requestUser, requestName, requestToko, requestEnt, requestDC, requestKate, requestNotelp, requestKet,requestStatus );
                    create.enqueue(new Callback<CreateResponse>() {
                        @Override
                        public void onResponse(Call<CreateResponse> call, Response<CreateResponse> response) {
                            String kode = response.body().getStatusCode();
                            if (kode.equals("0016")) {

                                Toast.makeText(CreateActivity.this, getString(R.string.msg_success), Toast.LENGTH_SHORT).show();
                                finish();
                            } else {

                                Toast.makeText(CreateActivity.this, getString(R.string.msg_error), Toast.LENGTH_SHORT).show();
                                Log.d("kode:",kode);

                            }
                            finish();
                        }

                        @Override
                        public void onFailure(Call<CreateResponse> call, Throwable t) {

                        }
                    });
                }catch (Exception e){
                    Log.d("error", String.valueOf(e));
                }


            }

        });


    }
}
