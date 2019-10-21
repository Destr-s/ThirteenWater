package com.richer.thirteenwater.NetWork;

import org.jetbrains.annotations.NotNull;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class Network {
    public static Api api;
    public static void init() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(System.out::println);
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create())
                .baseUrl("http://www.revth.com:12300/")
                .client(client)
                .build();

        api = retrofit.create(Api.class);
    }
}