package com.richer.thirteenwater.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.richer.thirteenwater.NetWork.HttpRequest;
import com.richer.thirteenwater.NetWork.OpenResponse;
import com.richer.thirteenwater.R;

public class StartActivity extends AppCompatActivity {

    String card = null;
    String token = null;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final ImageView startButton = findViewById(R.id.start_game_start);
        ImageView joinButton = findViewById(R.id.join_room_start);

        Intent getToken = getIntent();
        token = getToken.getStringExtra("token");

        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                HttpRequest.open(token, new Callback<OpenResponse>() {
                    @Override
                    public void onResponse(Call<OpenResponse> call, Response<OpenResponse> response) {

                        if(response.body()!=null){
                            card = response.body().data.card;
                            id = response.body().data.id;
                        }

                        if(card!=null){
                            Intent intent = new Intent(StartActivity.this,PlayActivity.class);
                            intent.putExtra("token",token);
                            intent.putExtra("card",card);
                            intent.putExtra("id",id);
                            startActivity(intent);
                        }else{
                            Toast.makeText(StartActivity.this,"服务器异常！",Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<OpenResponse> call, Throwable t) {

                    }
                });

            }
        });
        joinButton.setOnClickListener(v -> {
            HttpRequest.open(token, new Callback<OpenResponse>() {
                @Override
                public void onResponse(Call<OpenResponse> call, Response<OpenResponse> response) {

                }

                @Override
                public void onFailure(Call<OpenResponse> call, Throwable t) {

                }
            });

            if(card!=null){
                Intent intent = new Intent(StartActivity.this,PlayActivity.class);
                intent.putExtra("card",card);
                startActivity(intent);
            }else{
                Toast.makeText(StartActivity.this,"服务器异常！",Toast.LENGTH_LONG).show();
            }
        });

        ImageView rankButton = findViewById(R.id.rank_img_start);
        rankButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this,RankActivity.class);
            startActivity(intent);
        });

        ImageView historyButton = findViewById(R.id.history_img_start);
        historyButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this,HistoryActivity.class);
            startActivity(intent);
        });

        ImageView ruleButton = findViewById(R.id.rule_img_start);
        ruleButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this,RuleActivity.class);
            startActivity(intent);
        });

        ImageView settingButton = findViewById(R.id.setting_img_start);
        settingButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this,SettingActivity.class);
            startActivity(intent);
        });

    }
}
