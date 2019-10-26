package com.richer.thirteenwater.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        id = getToken.getIntExtra("user_id",0);
        System.out.println("start_token:"+token);


        startButton.setOnClickListener(v -> {

            Intent intent = new Intent(StartActivity.this,PlayActivity.class);
            intent.putExtra("token",token);
            startActivity(intent);

        });
        joinButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this,PlayActivity.class);
            intent.putExtra("token",token);
            startActivity(intent);
        });

        ImageView rankButton = findViewById(R.id.rank_img_start);
        rankButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this,RankActivity.class);
            startActivity(intent);
        });

        ImageView historyButton = findViewById(R.id.history_img_start);
        historyButton.setOnClickListener(v -> {
            Intent intent = new Intent(StartActivity.this,HistoryActivity.class);
            intent.putExtra("token",token);
            intent.putExtra("player_id",id);
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
