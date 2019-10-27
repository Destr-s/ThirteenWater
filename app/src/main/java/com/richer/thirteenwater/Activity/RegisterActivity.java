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
import com.richer.thirteenwater.NetWork.Network;
import com.richer.thirteenwater.NetWork.RegisterResponse;
import com.richer.thirteenwater.R;

public class RegisterActivity extends AppCompatActivity {

    String name;
    String pwd;
    String confirmPwd;
    String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText et_name = findViewById(R.id.name_register);
        EditText et_pwd = findViewById(R.id.password_register);
        EditText et_confirm = findViewById(R.id.confirm_password_register);

        //隐藏密码
        et_pwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        et_confirm.setTransformationMethod(PasswordTransformationMethod.getInstance());

        Button doneButton = findViewById(R.id.done_register);
        Button cancelButton = findViewById(R.id.cancel_register);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = et_name.getText().toString();
                pwd = et_pwd.getText().toString();
                confirmPwd = et_confirm.getText().toString();

                if(!pwd.equals(confirmPwd)){
                    Toast.makeText(RegisterActivity.this,"两次输入密码不同！",Toast.LENGTH_LONG).show();
                }else{
                    System.out.println(name+"----"+pwd);
                    HttpRequest.register(name, pwd, new Callback<RegisterResponse>() {
                        @Override
                        public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {

                            if(response.body()!=null){
                                msg = (response.body().data.msg);
                                System.out.println("msg: "+msg);
                            }

                            if("Success".equals(msg)){
                                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);
                            }else{
                                //Toast.makeText(RegisterActivity.this,"用户名已存在！",Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<RegisterResponse> call, Throwable t) {

                        }
                    });

                }
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
