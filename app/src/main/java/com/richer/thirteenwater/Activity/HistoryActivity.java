package com.richer.thirteenwater.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.richer.thirteenwater.Adapter.HistoryAdapter;
import com.richer.thirteenwater.Adapter.RankAdapter;
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

        Intent intent = getIntent();
        token = intent.getStringExtra("token");

        List<HistoryResponse> historyResponseList = new ArrayList<>();

        HttpRequest.getHistory(token,new Callback<List<HistoryResponse>>(){

            @Override
            public void onResponse(Call<List<HistoryResponse>> call, Response<List<HistoryResponse>> response) {

                if(response.body()==null){
                    Toast.makeText(HistoryActivity.this,"无数据",Toast.LENGTH_LONG).show();
                }else{
                    for(int i=0;i<response.body().size();i++){
                        historyResponseList.add(response.body().get(i));
                    }
                    for(HistoryResponse historyResponse : historyResponseList){
                        System.out.println("id:"+historyResponse.data.id);
                    }
                    RecyclerView recyclerView = findViewById(R.id.history_recyclerview);
                    LinearLayoutManager manager = new LinearLayoutManager(HistoryActivity.this);
                    recyclerView.setLayoutManager(manager);
                    HistoryAdapter adapter = new HistoryAdapter(historyResponseList,token);
                    recyclerView.setAdapter(adapter);

                }

            }

            @Override
            public void onFailure(Call<List<HistoryResponse>> call, Throwable t) {

            }
        });

        Button returnButton = findViewById(R.id.return_history);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HistoryActivity.this,StartActivity.class);
                startActivity(intent);
            }
        });

    }
}
