package com.richer.thirteenwater.Activity;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.richer.thirteenwater.AI.Solve;
import com.richer.thirteenwater.NetWork.HttpRequest;
import com.richer.thirteenwater.NetWork.OpenResponse;
import com.richer.thirteenwater.NetWork.SubmitResponse;
import com.richer.thirteenwater.R;

import java.io.IOException;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlayActivity extends AppCompatActivity {

    String card = null;
    String token = null;
    int id;
    boolean flag = true;
    List<ImageView> imageViewList  = new ArrayList<>();
    CheckBox auto;
    TextView tv_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        auto = findViewById(R.id.auto_play);

        Intent intent = getIntent();
        token = intent.getStringExtra("token");
        String name = intent.getStringExtra("name");

        TextView tv_name = findViewById(R.id.message_play);
        tv_name.setText(name);
        TextView tv_name2 = findViewById(R.id.message_play2);
        tv_name2.setText(name);

        ImageView front_1 = findViewById(R.id.front_1);
        ImageView front_2 = findViewById(R.id.front_2);
        ImageView front_3 = findViewById(R.id.front_3);
        ImageView mid_1 = findViewById(R.id.mid_1);
        ImageView mid_2 = findViewById(R.id.mid_2);
        ImageView mid_3 = findViewById(R.id.mid_3);
        ImageView mid_4 = findViewById(R.id.mid_4);
        ImageView mid_5 = findViewById(R.id.mid_5);
        ImageView back_1 = findViewById(R.id.back_1);
        ImageView back_2 = findViewById(R.id.back_2);
        ImageView back_3 = findViewById(R.id.back_3);
        ImageView back_4 = findViewById(R.id.back_4);
        ImageView back_5 = findViewById(R.id.back_5);

        imageViewList.add(front_1);
        imageViewList.add(front_2);
        imageViewList.add(front_3);
        imageViewList.add(mid_1);
        imageViewList.add(mid_2);
        imageViewList.add(mid_3);
        imageViewList.add(mid_4);
        imageViewList.add(mid_5);
        imageViewList.add(back_1);
        imageViewList.add(back_2);
        imageViewList.add(back_3);
        imageViewList.add(back_4);
        imageViewList.add(back_5);

        Button returnButton = findViewById(R.id.return_play);
        tv_id = findViewById(R.id.id_play);
        Button nextButton = findViewById(R.id.next_game_play);

        open();

        nextButton.setOnClickListener(v -> open());

        returnButton.setOnClickListener(v -> {
            flag = false;
            finish();
        });

    }

    public void initPoker(String[] card,List<ImageView> imageViews) {

        List<String> cards = new ArrayList<>();

        for(int i=0;i<card.length;i++){
            String[] s = card[i].split(" ");
            cards.addAll(Arrays.asList(s));
        }

        for (int i = 0; i < cards.size(); i++) {

            StringBuilder sb = new StringBuilder();
            String s = cards.get(i);

            switch (s.charAt(0)) {
                case '#':
                    sb.append("f");
                    break;
                case '$':
                    sb.append("b");
                    break;
                case '&':
                    sb.append("r");
                    break;
                case '*':
                    sb.append("c");
                    break;
            }
            String origin = s.substring(1);
            switch (origin) {
                case "J":
                    origin = "j";
                    break;
                case "Q":
                    origin = "q";
                    break;
                case "K":
                    origin = "k";
                    break;
                case "A":
                    origin = "a";
                    break;
                default:
                    break;
            }
            sb.append(origin);
            String name = sb.toString();
            Resources resources = this.getResources();
            System.out.println("name:"+name);
            int resourceId = resources.getIdentifier(
                    name, "drawable",
                    this.getPackageName());
            Drawable drawable = resources.getDrawable(resourceId, null);
            if(flag){
                Glide.with(this).load(drawable).into(imageViews.get(i));
            }
        }
    }

    public void open(){
        HttpRequest.open(token, new Callback<OpenResponse>() {
            @Override
            public void onResponse(Call<OpenResponse> call, Response<OpenResponse> response) {

                if(response.body()!=null){
                    card = response.body().data.card;
                    id = response.body().data.id;
                    tv_id.setText(String.valueOf(id));
                    String[] cards = new String[0];
                    try {
                        cards = Solve.solve(card);
                        final String[] finalCards = cards;

                        initPoker(finalCards,imageViewList);

                        submit(finalCards);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<OpenResponse> call, Throwable t) {

            }
        });

    }

    public void submit(String[] finalCards){

        HttpRequest.submit(finalCards,id,token,new Callback<SubmitResponse>() {

            @Override
            public void onResponse(Call<SubmitResponse> call, Response<SubmitResponse> response) {

                if(response.body()!=null){
                    System.out.println("submit: "+response.body().data.msg);


                }else{
                    System.out.println("error");
                }
                if(auto.isChecked()&&flag){
                    open();
                }
            }

            @Override
            public void onFailure(Call<SubmitResponse> call, Throwable t) {

            }
        });

    }
}
