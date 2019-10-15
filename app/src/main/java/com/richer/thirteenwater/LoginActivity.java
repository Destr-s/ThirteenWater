package com.richer.thirteenwater;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button doneButton = findViewById(R.id.done_login);
        Button cancelButton = findViewById(R.id.cancel_login);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,StartActivity.class);
                startActivity(intent);
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        EditText etName = findViewById(R.id.name_login);
        String name = etName.getText().toString();
        EditText etPassword = findViewById(R.id.password_login);
        String pwd = etPassword.getText().toString();

        

    }
}
