package com.richer.thirteenwater.NetWork;

public class LoginResponse {
    int status;
    public Data data;
    public static class Data {
        public int user_id;
        public String token;
    }
}