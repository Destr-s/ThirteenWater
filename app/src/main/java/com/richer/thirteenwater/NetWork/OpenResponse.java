package com.richer.thirteenwater.NetWork;

public class OpenResponse {
    int status;
    public Data data;
    public static class Data {
        public int id;
        public String card;
    }
}