package com.richer.thirteenwater.NetWork;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.core.app.NavUtils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpRequest {

    static String msg = null;
    static String token;
    static String card;
    static int gameId;

    public static void register(String name,String pwd,Callback<RegisterResponse> callback) {
        Network.api.register(new UserDto(name,pwd)).enqueue(callback);
    }

    public static void open(String token,Callback<OpenResponse> callback) {
        Network.api.open(token).enqueue(callback);

    }

    public static void login(String name,String pwd,Callback<LoginResponse> callback) {
        Network.api.login(new UserDto(name,pwd)).enqueue(callback);
    }

    public static void submit(String[] cards,int id,String token,Callback<SubmitResponse> callback) {

        Network.api.submit(token,new SubmitRequest(id,cards)).enqueue(callback);
    }

    public static void getRank(Callback<List<RankResponse>> callback){

        Network.api.getRank().enqueue(callback);

    }
    public static void getHistory(String token,Callback<List<HistoryResponse>> callback){
        Network.api.getHistory(token).enqueue(callback);
    }

    public static void getDetails(String token,Callback<List<HistoryResponse>> callback){

    }

}
