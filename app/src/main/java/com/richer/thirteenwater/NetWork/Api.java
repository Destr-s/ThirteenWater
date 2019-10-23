package com.richer.thirteenwater.NetWork;

import java.util.List;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @POST("register")
    Call<RegisterResponse> register(@Body UserDto user);

    @POST("auth/login")
    Call<LoginResponse> login(@Body UserDto user);

    @POST("game/open")
    Call<OpenResponse> open(@Header("X-Auth-Token") String token);

    @POST("game/submit")
    Call<SubmitResponse> submit(@Header("X-Auth-Token") String token, @Body SubmitRequest request);

    @GET("rank")
    Call<List<RankResponse>> getRank();

    @GET("history")
    Call<List<HistoryResponse>> getHistory(@Header("X-Auth-Token") String token);

}
