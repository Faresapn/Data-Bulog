package com.faresa.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.faresa.myapplication.db.FavoriteHelper;
import com.faresa.myapplication.pojo.getbarang.GetBarang;

import java.util.ArrayList;

public class CheckoutActivity extends AppCompatActivity {
    private ArrayList<GetBarang> list;
    private FavoriteHelper favoriteHelper;
    private CartAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        favoriteHelper = FavoriteHelper.getInst(CheckoutActivity.this);
        favoriteHelper.open();

        RecyclerView rv = findViewById(R.id.rv_cart);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(CheckoutActivity.this));

        adapter = new CartAdapter(this);


        rv.setAdapter(adapter);
    }

    @Override
    public void onResume(){
        super.onResume();
        list = favoriteHelper.getAllFavorites();
        adapter.setBarangs(list);

    }
}
