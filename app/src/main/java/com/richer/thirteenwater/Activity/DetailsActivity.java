package com.richer.thirteenwater.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.richer.thirteenwater.Adapter.DetailAdapter;
import com.richer.thirteenwater.Adapter.HistoryAdapter;
import com.richer.thirteenwater.NetWork.DetailData;
import com.richer.thirteenwater.NetWork.DetailResponse;
import com.richer.thirteenwater.NetWork.HttpRequest;
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

        TextView roomId = findViewById(R.id.room_num_details);
        roomId.setText(String.valueOf(id));

        List<DetailResponse> detailResponses = new ArrayList<>();

        HttpRequest.getDetails(token, id, new Callback<DetailData>() {
            @Override
            public void onResponse(Call<DetailData> call, Response<DetailData> response) {

                for(int i=0;i<response.body().data.detail.size();i++){
                    detailResponses.add(response.body().data.detail.get(i));
                }
                RecyclerView recyclerView = findViewById(R.id.detail_recyclerView);
                LinearLayoutManager manager = new LinearLayoutManager(DetailsActivity.this);
                recyclerView.setLayoutManager(manager);
                DetailAdapter adapter = new DetailAdapter(detailResponses);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<DetailData> call, Throwable t) {

            }
        });

        Button returnButton = findViewById(R.id.return_details);
        returnButton.setOnClickListener(v -> {
            finish();
        });

    }

}
