package com.faresa.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.faresa.myapplication.pojo.getbarang.GetBarang;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
    private List<GetBarang> getBarangs;

    void setBarangs(List<GetBarang> getBarangs) {
        this.getBarangs = getBarangs;
    }
    private CheckoutActivity dataBarang;

    public CartAdapter(CheckoutActivity dataBarangActivity) {
        this.dataBarang = dataBarangActivity;
    }
    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemscart, parent,false);
        return new CartAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        holder.nama.setText(getBarangs.get(position).getNama());
        holder.harga.setText(String.valueOf(getBarangs.get(position).getHarga()));
    }

    @Override
    public int getItemCount()  {
        return getBarangs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private int mCount = 0;
        TextView nama,harga,Jumlah,minus,plus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.namabarang);
            harga = itemView.findViewById(R.id.hargabarang);
            Jumlah = itemView.findViewById(R.id.jumlah);
            plus = itemView.findViewById(R.id.plus);
            minus = itemView.findViewById(R.id.minus);
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
}
