package com.faresa.myapplication.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.faresa.myapplication.connection.Client;
import com.faresa.myapplication.connection.Service;
import com.faresa.myapplication.pojo.GetData;
import com.faresa.myapplication.pojo.getbarang.BarangResponse;
import com.faresa.myapplication.pojo.getbarang.GetBarang;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BarangViewModel extends AndroidViewModel {
    private MutableLiveData<BarangResponse> getBarang;
    public BarangViewModel(@NonNull Application application) {
        super(application);
    }
    public void loadEvent() {
        try {

            Service service = Client.getClient().create(Service.class);
            Call<BarangResponse> eventCall = service.getBarang();
            eventCall.enqueue(new Callback<BarangResponse>() {

                @Override
                public void onResponse(Call<BarangResponse> call, Response<BarangResponse> response) {

                    getBarang.setValue(response.body());

                }

                @Override
                public void onFailure(Call<BarangResponse> call, Throwable t) {
                    Log.e("failure", t.toString());

                }
            });
        } catch (Exception e) {
            Log.d("token e", String.valueOf(e));
        }
    }

    public MutableLiveData<BarangResponse> liveGet() {
        if (getBarang == null) {
            getBarang = new MutableLiveData<>();
            loadEvent();
        }
        return getBarang;
    }
}
