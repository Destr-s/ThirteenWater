package com.richer.thirteenwater.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.richer.thirteenwater.Adapter.HistoryAdapter;
import com.richer.thirteenwater.Adapter.RankAdapter;
import com.richer.thirteenwater.NetWork.HistoryData;
import com.richer.thirteenwater.NetWork.HistoryResponse;
import com.richer.thirteenwater.NetWork.HttpRequest;
import com.richer.thirteenwater.NetWork.RankResponse;
import com.richer.thirteenwater.R;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        String token;
        int player_id;

        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        player_id = intent.getIntExtra("player_id",0);
        System.out.println("history_token:"+token);

        List<HistoryResponse> historyResponseList = new ArrayList<>();

        HttpRequest.getHistory(token, player_id, 20, 0, new Callback<HistoryData>() {
            @Override
            public void onResponse(Call<HistoryData> call, Response<HistoryData> response) {

                System.out.println("11111");
                for(int i=0;i<response.body().data.size();i++){
                    historyResponseList.add(response.body().data.get(i));
                }
                RecyclerView recyclerView = findViewById(R.id.history_recyclerview);
                LinearLayoutManager manager = new LinearLayoutManager(HistoryActivity.this);
                recyclerView.setLayoutManager(manager);
                HistoryAdapter adapter = new HistoryAdapter(historyResponseList,token);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<HistoryData> call, Throwable t) {
                System.out.println("0000000");
            }
        });

        Button returnButton = findViewById(R.id.return_history);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
