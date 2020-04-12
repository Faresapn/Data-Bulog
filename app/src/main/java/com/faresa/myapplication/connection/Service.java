package com.faresa.myapplication.connection;



import com.faresa.myapplication.pojo.GetData;
import com.faresa.myapplication.pojo.create.CreateResponse;
import com.faresa.myapplication.pojo.delete.Delete;
import com.faresa.myapplication.pojo.update.UpdateResponse;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;


public interface Service {


   @GET("data")
   Call<GetData> getData();

    @Multipart
   @POST("create")
    Call<CreateResponse>createData( @Part("ktp") RequestBody ktp,
                                    @Part("npwp") RequestBody npwp,
                                    @Part("alamat")   RequestBody alamat,
                                    @Part("provinsi") RequestBody provinsi,
                                    @Part("kota")     RequestBody kota,
                                    @Part("kecamatan")RequestBody kecamatan,
                                    @Part("kelurahan")RequestBody kelurahan,
                                    @Part("username") RequestBody username,
                                    @Part("pemilik")  RequestBody pemilik,
                                    @Part("toko")     RequestBody toko,
                                    @Part("entitas")  RequestBody entitas,
                                    @Part("dc")       RequestBody dc,
                                    @Part("kategori") RequestBody kategori,
                                    @Part("telfon")    RequestBody telfon,
                                    @Part("keterangan") RequestBody ket,
                                    @Part("status")     RequestBody status

   );
    @Multipart
    @POST("update/{id}")
    Call<UpdateResponse>update(@Part("ktp") RequestBody ktp,
                               @Part("npwp") RequestBody npwp,
                               @Part("alamat")   RequestBody alamat,
                               @Part("provinsi") RequestBody provinsi,
                               @Part("kota")     RequestBody kota,
                               @Part("kecamatan")RequestBody kecamatan,
                               @Part("kelurahan")RequestBody kelurahan,
                               @Part("username") RequestBody username,
                               @Part("pemilik")  RequestBody pemilik,
                               @Part("toko")     RequestBody toko,
                               @Part("entitas")  RequestBody entitas,
                               @Part("dc")       RequestBody dc,
                               @Part("kategori") RequestBody kategori,
                               @Part("telfon")    RequestBody telfon,
                               @Part("keterangan") RequestBody ket,
                               @Part("status")     RequestBody status,
                               @Path("id") String id

    );
    @DELETE("delete/{id}")
    Call<Delete> delete(@Path("id") int id);




}
