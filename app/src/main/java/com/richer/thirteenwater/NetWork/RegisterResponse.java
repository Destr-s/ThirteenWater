package com.richer.thirteenwater.NetWork;

public class RegisterResponse {
    int status;
    public Data data;
    public static class Data {
        public String msg;
        public int user_id;
    }
}