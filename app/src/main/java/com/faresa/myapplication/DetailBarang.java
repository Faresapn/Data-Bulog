package com.faresa.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.faresa.myapplication.db.DbContract;
import com.faresa.myapplication.db.FavoriteDbHelper;
import com.faresa.myapplication.db.FavoriteHelper;
import com.faresa.myapplication.pojo.getbarang.GetBarang;
import com.github.ivbaranov.mfb.MaterialFavoriteButton;

import java.util.ArrayList;

import static com.faresa.myapplication.db.DbContract.FavoriteColoumn.TABLE_FAVORITE_NAME;

public class DetailBarang extends AppCompatActivity {
    TextView nama,harga,stok,ket,Jumlah,plus,minus;
    GetBarang barang;
    private int mCount = 0;
    private FavoriteHelper favoriteHelper ;
    ArrayList<GetBarang> list = new ArrayList<>();
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
        final MaterialFavoriteButton favBtn = findViewById(R.id.cart);
        favoriteHelper = FavoriteHelper.getInst(getApplicationContext());
        favoriteHelper.open();

        if (Exist(barang.getNama())){
            favBtn.setFavorite(true);
            favBtn.setOnFavoriteChangeListener(
                    new MaterialFavoriteButton.OnFavoriteChangeListener() {
                        @Override
                        public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                            if (favorite){
                                list = favoriteHelper.getAllFavorites();
                                favoriteHelper.favoriteInsert(barang);
                                Toast toast = Toast.makeText(getApplicationContext(),"Ditambahkan Favorite",Toast.LENGTH_SHORT);
                                toast.show();

                            }
                            else {
                                list = favoriteHelper.getAllFavorites();
                                favoriteHelper.favoriteDelete(barang.getNama());
                                Toast toast = Toast.makeText(getApplicationContext(),"Dihapus Favorite",Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }
                    });

        }else {
            favBtn.setOnFavoriteChangeListener(
                    new MaterialFavoriteButton.OnFavoriteChangeListener() {
                        @Override
                        public void onFavoriteChanged(MaterialFavoriteButton buttonView, boolean favorite) {
                            if (favorite){
                                list = favoriteHelper.getAllFavorites();
                                favoriteHelper.favoriteInsert(barang);
                                Toast toast = Toast.makeText(getApplicationContext(),"Ditambahkan Favorite",Toast.LENGTH_SHORT);
                                toast.show();

                            }
                            else {
                                list = favoriteHelper.getAllFavorites();
                                favoriteHelper.favoriteDelete(barang.getNama());
                                Toast toast = Toast.makeText(getApplicationContext(),"Dihapus Favorite",Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }
                    });
        }

    }
    public boolean Exist(String item) {
        String pilih = DbContract.FavoriteColoumn.TITLE+" =?";
        String[] pilihArg = {item};
        String limit = "1";
        favoriteHelper = new FavoriteHelper(this);
        favoriteHelper.open();
        FavoriteDbHelper dataBaseHelper = new FavoriteDbHelper(DetailBarang.this);
        SQLiteDatabase database = dataBaseHelper.getWritableDatabase();
        Cursor cursor = database.query(TABLE_FAVORITE_NAME, null, pilih, pilihArg, null, null, null, limit);
        boolean exists;
        exists = (cursor.getCount() > 0);
        cursor.close();
//        movieHelper.close();
        return exists;
    }


}
