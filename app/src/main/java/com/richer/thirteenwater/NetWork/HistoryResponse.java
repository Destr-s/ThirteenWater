package com.richer.thirteenwater.NetWork;

import java.util.List;

public class HistoryResponse {

    int status;
    public Data data;
    public static class Data {
        public int id;
        public String[] card;
    }
    public int score;
}
