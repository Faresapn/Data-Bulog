package com.faresa.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
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
import com.faresa.myapplication.pojo.DataItem;
import com.faresa.myapplication.pojo.GetData;
import com.faresa.myapplication.pojo.create.CreateResponse;
import com.faresa.myapplication.pojo.update.UpdateData;
import com.faresa.myapplication.pojo.update.UpdateResponse;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        submit = findViewById(R.id.save);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                String noTelp = telfon.getEditText().getText().toString().trim();
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
                String id = String.valueOf(dataGet.getBulogId());
                RequestBody requestput = RequestBody.create("PUT", MediaType.parse("multipart/form-data"));
                RequestBody requestStatus = RequestBody.create(status.getSelectedItem().toString().trim(), MediaType.parse("multipart/form-data"));
                RequestBody requestKet = RequestBody.create(keterangan.getSelectedItem().toString().trim(), MediaType.parse("multipart/form-data"));
                try {
                    Service service = Client.getClient().create(Service.class);
                    Call<UpdateResponse> create = service.update(requestKtp, requestNPWP, requestAlamat, requestProvinsi, requestKota
                            , requestKec, requestKel, requestUser, requestName, requestToko, requestEnt, requestDC, requestKate, requestNotelp, requestKet,requestStatus,id );
                    create.enqueue(new Callback<UpdateResponse>() {
                        @Override
                        public void onResponse(Call<UpdateResponse> call, Response<UpdateResponse> response) {
                            String kode = response.body().getStatusCode();
                            if (kode.equals("0001")) {

                                Toast.makeText(EditActivity.this, getString(R.string.msg_success), Toast.LENGTH_SHORT).show();
                                finish();
                            } else {

                                Toast.makeText(EditActivity.this, getString(R.string.msg_error), Toast.LENGTH_SHORT).show();
                                Log.d("kode:",kode);

                            }
                            finish();
                        }

                        @Override
                        public void onFailure(Call<UpdateResponse> call, Throwable t) {

                        }
                    });
                }catch (Exception e){
                    Log.d("error", String.valueOf(e));
                }


            }

        });
    }
}
