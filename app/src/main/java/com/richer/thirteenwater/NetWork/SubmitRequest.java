package com.richer.thirteenwater.NetWork;

import java.util.List;

public class SubmitRequest {
    int id;
    String[] card;
    SubmitRequest(int id,String[] card) {
        this.id = id;
        this.card = card;
        System.out.println(id+" "+card);
    }
}
