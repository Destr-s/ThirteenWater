package com.richer.thirteenwater.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.richer.thirteenwater.NetWork.DetailResponse;
import com.richer.thirteenwater.R;

import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent1 = getIntent();
        int id = intent1.getIntExtra("id",1000);
        String token = intent1.getStringExtra("token");

        String response = getDetails(id,token);
        List<DetailResponse> detailResponses = getMsg(response);



        Button returnButton = findViewById(R.id.return_details);
        returnButton.setOnClickListener(v -> {
            Intent intent = new Intent(DetailsActivity.this,HistoryActivity.class);
            startActivity(intent);
        });

    }

    public String getDetails(int id,String token){

        final String[] re = new String[1];
        String url = "http://api.revth.com/history/"+id;
        Request.Builder builder = new Request.Builder().url(url).addHeader("X-Auth-Token",token);
        Request request = builder.build();
        OkHttpClient client = new OkHttpClient.Builder().build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                re[0] = request.body().toString();
            }
        });
        return re[0];
    }

    public List<DetailResponse> getMsg(String response){

        List<DetailResponse> detailResponseList = new ArrayList<>();

        try{
            JSONObject object = new JSONObject(response);
            JSONObject data = object.getJSONObject("data");
            JSONArray detail = data.getJSONArray("detail");
            for(int i=0;i<detail.length();i++){
                JSONObject player = detail.getJSONObject(i);
                int playerId = player.getInt("player_id");
                String name = player.getString("name");
                int score = player.getInt("score");
                JSONArray card = player.getJSONArray("card");
                List<String> cards = null;
                for(int j=0;j<card.length();j++){
                    cards.add(card.getString(j));
                }
                DetailResponse r = new DetailResponse(playerId,name,score,cards);
                detailResponseList.add(r);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return detailResponseList;

    }

}
