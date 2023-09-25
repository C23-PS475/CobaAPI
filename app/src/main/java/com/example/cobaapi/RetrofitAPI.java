package com.example.cobaapi;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import okhttp3.MediaType;
import retrofit2.http.Field;
import retrofit2.http.Part;
import retrofit2.http.FormUrlEncoded;

public interface RetrofitAPI {
    @FormUrlEncoded
    //@Headers("Content-Type:multipart/form-data")
    @POST("store/data/index.php")
    Call<ApiResponse> sendData(
            @Field("sn") String sn,
            @Field("username") String username,
            @Field("location") String location,
            @Field("lat") String latitude,
            @Field("lon")  String longitude
    );
}



