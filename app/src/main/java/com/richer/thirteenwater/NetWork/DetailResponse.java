package com.richer.thirteenwater.NetWork;

import java.util.List;

public class DetailResponse {

    public int playerId;
    public String name;
    public int score;
    public List<String> card;

    public DetailResponse(int playerId, String name, int score, List<String> card) {
        this.playerId = playerId;
        this.name = name;
        this.score = score;
        this.card = card;
    }
}
