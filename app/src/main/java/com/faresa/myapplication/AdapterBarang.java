package com.faresa.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faresa.myapplication.pojo.DataItem;
import com.faresa.myapplication.pojo.getbarang.GetBarang;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.ViewHolder> {
    private List<GetBarang> getBarangs;

    void setBarangs(List<GetBarang> getBarangs) {
        this.getBarangs = getBarangs;
    }
    private DataBarangActivity dataBarang;

    public AdapterBarang(DataBarangActivity dataBarangActivity) {
        this.dataBarang = dataBarangActivity;
    }

    @NonNull
    @Override
    public AdapterBarang.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsbarang, parent,false);
        return new AdapterBarang.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBarang.ViewHolder holder, int position) {
        holder.nama.setText(getBarangs.get(position).getNama());
        holder.harga.setText(String.valueOf(getBarangs.get(position).getHarga()));

    }

    @Override
    public int getItemCount() {
        return getBarangs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nama,harga;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.namabarang);
            harga = itemView.findViewById(R.id.hargabarang);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        GetBarang data = getBarangs.get(position);
                        Intent intent = new Intent(dataBarang, DetailBarang.class);
                        intent.putExtra("data", data);
                        Objects.requireNonNull(dataBarang).startActivity(intent);
                    }
                }
            });
        }
    }
}
