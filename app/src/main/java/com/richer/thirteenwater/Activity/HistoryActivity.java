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
import android.widget.TextView;
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

    String token;
    int player_id;
    int page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        page=0;

        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        player_id = intent.getIntExtra("player_id",0);
        String name = intent.getStringExtra("name");

        TextView tv_name = findViewById(R.id.message_history);
        tv_name.setText(name);

        Button bt_next = findViewById(R.id.next_page_history);
        Button bt_last = findViewById(R.id.last_page_history);

        System.out.println("player_id:"+player_id);
        getHistory(page);

        bt_next.setOnClickListener(v -> {
            page++;
            getHistory(page);
        });

        bt_last.setOnClickListener(v -> {
            if(page>0){
                page--;
                getHistory(page);
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

    public void getHistory(int page){

        List<HistoryResponse> historyResponseList = new ArrayList<>();

        HttpRequest.getHistory(token, player_id, 20, page, new Callback<HistoryData>() {
            @Override
            public void onResponse(Call<HistoryData> call, Response<HistoryData> response) {

                if(response.body()!=null){
                    for(int i=0;i<response.body().data.size();i++){
                        historyResponseList.add(response.body().data.get(i));
                        System.out.println(i+""+response.body().data.get(i).score);
                    }
                    RecyclerView recyclerView = findViewById(R.id.history_recyclerview);
                    LinearLayoutManager manager = new LinearLayoutManager(HistoryActivity.this);
                    recyclerView.setLayoutManager(manager);
                    HistoryAdapter adapter = new HistoryAdapter(historyResponseList,token);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<HistoryData> call, Throwable t) {
            }
        });
    }

}
