package com.faresa.myapplication.connection;



import com.faresa.myapplication.pojo.GetData;
import com.faresa.myapplication.pojo.create.CreateResponse;
import com.faresa.myapplication.pojo.delete.Delete;
import com.faresa.myapplication.pojo.update.UpdateResponse;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface Service {


   @GET("data")
   Call<GetData> getData();

   @FormUrlEncoded
   @POST("create")
    Call<CreateResponse>createData( @Field("ktp") String ktp,
                                    @Field("npwp") String npwp,
                                    @Field("alamat") String alamat,
                                    @Field("provinsi") String provinsi,
                                    @Field("kota") String kota,
                                    @Field("kecamatan") String kecamatan,
                                    @Field("kelurahan") String kelurahan,
                                    @Field("username") String username,
                                    @Field("pemilik") String pemilik,
                                    @Field("toko") String toko,
                                    @Field("entitas") String entitas,
                                    @Field("dc") String dc,
                                    @Field("kategori") String kategori,
                                    @Field("telfon") int telfon,
                                    @Field("keterangan") String ket,
                                    @Field("status") String status

   );
    @FormUrlEncoded
    @POST("update/{id}")
    Call<UpdateResponse>update(@Field("ktp") String ktp,
                                   @Field("npwp") String npwp,
                                   @Field("alamat") String alamat,
                                   @Field("provinsi") String provinsi,
                                   @Field("kota") String kota,
                                   @Field("kecamatan") String kecamatan,
                                   @Field("kelurahan") String kelurahan,
                                   @Field("username") String username,
                                   @Field("pemilik") String pemilik,
                                   @Field("toko") String toko,
                                   @Field("entitas") String entitas,
                                   @Field("dc") String dc,
                                   @Field("kategori") String kategori,
                                   @Field("telfon") int telfon,
                                   @Field("keterangan") String ket,
                                   @Field("status") String status,
                                   @Field("_method") String put,
                                   @Path("id") String id

    );
    @DELETE("delete/{id}")
    Call<Delete> delete(@Path("id") int id);




}
