package com.richer.thirteenwater.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.richer.thirteenwater.Adapter.RankAdapter;
import com.richer.thirteenwater.NetWork.HttpRequest;
import com.richer.thirteenwater.NetWork.RankResponse;
import com.richer.thirteenwater.R;

import java.util.ArrayList;
import java.util.List;

public class RankActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rank);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView tv_name = findViewById(R.id.message_rank);
        tv_name.setText(name);

        List<RankResponse> rankResponseList = new ArrayList<>();

        HttpRequest.getRank(new Callback<List<RankResponse>>() {
            @Override
            public void onResponse(Call<List<RankResponse>> call, Response<List<RankResponse>> response) {
                for(int i=0;i<response.body().size();i++){
                    rankResponseList.add(response.body().get(i));
                }
                for(RankResponse rankResponse : rankResponseList){
                    System.out.println("rank:"+rankResponse.getName());
                }
                RecyclerView recyclerView = findViewById(R.id.rank_recyclerview);
                LinearLayoutManager manager = new LinearLayoutManager(RankActivity.this);
                recyclerView.setLayoutManager(manager);
                RankAdapter adapter = new RankAdapter(rankResponseList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<RankResponse>> call, Throwable t) {

            }
        });



        Button returnButton = findViewById(R.id.return_rank);
        returnButton.setOnClickListener(v -> {
            finish();
        });

    }
}
