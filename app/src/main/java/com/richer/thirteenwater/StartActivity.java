package com.richer.thirteenwater;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        final ImageView startButton = findViewById(R.id.start_game_start);
        ImageView joinButton = findViewById(R.id.join_room_start);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,PlayActivity.class);
                startActivity(intent);
            }
        });
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,PlayActivity.class);
                startActivity(intent);
            }
        });

        ImageView rankButton = findViewById(R.id.rank_img_start);
        rankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,RankActivity.class);
                startActivity(intent);
            }
        });

        ImageView historyButton = findViewById(R.id.history_img_start);
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,HistoryActivity.class);
                startActivity(intent);
            }
        });

        ImageView ruleButton = findViewById(R.id.rule_img_start);
        ruleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,RuleActivity.class);
                startActivity(intent);
            }
        });

        ImageView settingButton = findViewById(R.id.setting_img_start);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });

    }
}
