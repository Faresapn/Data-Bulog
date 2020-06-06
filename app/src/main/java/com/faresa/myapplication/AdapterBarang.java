package com.faresa.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterBarang extends RecyclerView.Adapter<AdapterBarang.ViewHolder> {
    @NonNull
    @Override
    public AdapterBarang.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsbarang, parent,false);
        return new AdapterBarang.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBarang.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
