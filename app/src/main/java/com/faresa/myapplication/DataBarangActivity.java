package com.faresa.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.faresa.myapplication.ViewModel.BarangViewModel;
import com.faresa.myapplication.ViewModel.DataViewModel;
import com.faresa.myapplication.pojo.DataItem;
import com.faresa.myapplication.pojo.GetData;
import com.faresa.myapplication.pojo.getbarang.BarangResponse;
import com.faresa.myapplication.pojo.getbarang.GetBarang;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DataBarangActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BarangViewModel barangViewModel;
    private AdapterBarang adapterBarang;
    private LinearLayoutManager layoutManager = new LinearLayoutManager(DataBarangActivity.this, LinearLayoutManager.VERTICAL, false);
    private ProgressBar pb;
    private List<GetBarang> data = new ArrayList<>();
    ConstraintLayout null_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_barang);
        barangViewModel = ViewModelProviders.of(this).get(BarangViewModel.class);
        adapterBarang = new AdapterBarang(this);
        adapterBarang.setBarangs(data);
        recyclerView = findViewById(R.id.rv_data);
        null_layout = findViewById(R.id.null_image);
FloatingActionButton fv = findViewById(R.id.floatingActionButton);
fv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent2 = new Intent(DataBarangActivity.this,CheckoutActivity.class);
        startActivity(intent2);
    }
});
        initRV();
        pb = findViewById(R.id.pb);
        getData();
        pb.setVisibility(View.VISIBLE);

    }
    private void getData(){
        try {
            barangViewModel.liveGet().observe(this, new Observer<BarangResponse>() {
                @Override
                public void onChanged(BarangResponse barangResponse) {

                    try {
                        data.clear();

                        data.addAll(barangResponse.getData());
                        recyclerView.setAdapter(adapterBarang);
                        adapterBarang.notifyDataSetChanged();
                        pb.setVisibility(View.GONE);
                        null_layout.setVisibility(View.GONE);
                    } catch (Exception e) {
                        null_layout.setVisibility(View.VISIBLE);
                    }
                }
            });
        }catch (Exception e){

        }
    }

    private void initRV()  {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
    }
    @Override
    public void onResume() {
        super.onResume();
        barangViewModel.loadEvent();

    }
}
