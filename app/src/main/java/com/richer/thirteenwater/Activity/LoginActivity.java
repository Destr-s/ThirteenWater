package com.richer.thirteenwater.Activity;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.richer.thirteenwater.NetWork.HttpRequest;
import com.richer.thirteenwater.NetWork.LoginResponse;
import com.richer.thirteenwater.NetWork.Network;
import com.richer.thirteenwater.NetWork.UserDto;
import com.richer.thirteenwater.R;

public class LoginActivity extends AppCompatActivity {

    String name=null;
    String pwd=null;
    String token=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText et_name = findViewById(R.id.name_login);
        EditText et_password = findViewById(R.id.password_login);

        et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());

        Button doneButton = findViewById(R.id.done_login);
        Button cancelButton = findViewById(R.id.cancel_login);
        doneButton.setOnClickListener(v -> {

            name = et_name.getText().toString();
            pwd = et_password.getText().toString();

            HttpRequest.login(name, pwd, new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if(response.body()!=null) {
                        token = (response.body().data.token);
                        System.out.println("*token: " + token);
                    }
                    if(token!=null){
                        Intent intent = new Intent(LoginActivity.this,StartActivity.class);
                        intent.putExtra("token",token);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this,"密码错误！",Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });

            System.out.println("token: "+token);



        });
        cancelButton.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);
        });

    }
}
