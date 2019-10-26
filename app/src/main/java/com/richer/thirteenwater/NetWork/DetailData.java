package com.richer.thirteenwater.NetWork;

import java.util.List;

public class DetailData {

    public int status;
    public Data data;
    public static class Data{

        public int id;
        public String name;
        public List<DetailResponse> detail;

    }
}
