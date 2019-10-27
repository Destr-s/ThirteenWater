package com.richer.thirteenwater.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.richer.thirteenwater.R;

public class RuleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        TextView tv_name = findViewById(R.id.message_rule);
        tv_name.setText(name);

        Button returnButton = findViewById(R.id.return_rule);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
