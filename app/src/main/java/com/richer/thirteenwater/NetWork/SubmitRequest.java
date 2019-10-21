package com.richer.thirteenwater.NetWork;

import java.util.List;

public class SubmitRequest {
    int id;
    List<String> card;
    SubmitRequest(int id,List<String> card) {
        this.id = id;
        this.card = card;
        System.out.println(id+" "+card);
    }
}
