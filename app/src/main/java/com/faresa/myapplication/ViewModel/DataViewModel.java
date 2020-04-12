package com.faresa.myapplication.ViewModel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.faresa.myapplication.connection.Client;
import com.faresa.myapplication.connection.Service;
import com.faresa.myapplication.pojo.GetData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends AndroidViewModel {
    private MutableLiveData<GetData> getData;

    public DataViewModel(@NonNull Application application) {
        super(application);
    }
    public void loadEvent() {
        try {

            Service service = Client.getClient().create(Service.class);
            Call<GetData> eventCall = service.getData();
            eventCall.enqueue(new Callback<GetData>() {

                @Override
                public void onResponse(Call<GetData> call, Response<GetData> response) {

                    getData.setValue(response.body());

                }

                @Override
                public void onFailure(Call<GetData> call, Throwable t) {
                    Log.e("failure", t.toString());

                }
            });
        } catch (Exception e) {
            Log.d("token e", String.valueOf(e));
        }
    }

    public MutableLiveData<GetData> liveGet() {
        if (getData == null) {
            getData = new MutableLiveData<>();
            loadEvent();
        }
        return getData;
    }
}
