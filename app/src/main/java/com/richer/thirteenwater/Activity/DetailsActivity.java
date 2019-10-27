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

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
import org.w3c.dom.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DetailsActivity extends AppCompatActivity {

    List<ImageView> imageViewList  = new ArrayList<>();
    List<Integer> idList = new ArrayList<>();
    List<Integer> scoreList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Button bt_player_1 = findViewById(R.id.detail_player_1);
        Button bt_player_2 = findViewById(R.id.detail_player_2);
        Button bt_player_3 = findViewById(R.id.detail_player_3);
        Button bt_player_4 = findViewById(R.id.detail_player_4);

        Drawable d = bt_player_1.getBackground();

        TextView tv_score = findViewById(R.id.detail_score);

        ImageView front_1 = findViewById(R.id.detail_front_1);
        ImageView front_2 = findViewById(R.id.detail_front_2);
        ImageView front_3 = findViewById(R.id.detail_front_3);
        ImageView mid_1 = findViewById(R.id.detail_mid_1);
        ImageView mid_2 = findViewById(R.id.detail_mid_2);
        ImageView mid_3 = findViewById(R.id.detail_mid_3);
        ImageView mid_4 = findViewById(R.id.detail_mid_4);
        ImageView mid_5 = findViewById(R.id.detail_mid_5);
        ImageView back_1 = findViewById(R.id.detail_back_1);
        ImageView back_2 = findViewById(R.id.detail_back_2);
        ImageView back_3 = findViewById(R.id.detail_back_3);
        ImageView back_4 = findViewById(R.id.detail_back_4);
        ImageView back_5 = findViewById(R.id.detail_back_5);

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

        Intent intent1 = getIntent();
        int id = intent1.getIntExtra("id",1000);
        String token = intent1.getStringExtra("token");
        String name = intent1.getStringExtra("name");

        TextView tv_name = findViewById(R.id.message_details);
        tv_name.setText(name);

        TextView roomId = findViewById(R.id.room_num_details);
        roomId.setText(String.valueOf(id));

        List<DetailResponse> detailResponses = new ArrayList<>();

        HttpRequest.getDetails(token, id, new Callback<DetailData>() {
            @Override
            public void onResponse(Call<DetailData> call, Response<DetailData> response) {

                if(response.body()!=null){
                    for(int i=0;i<response.body().data.detail.size();i++){
                        detailResponses.add(response.body().data.detail.get(i));
                        idList.add(response.body().data.detail.get(i).player_id);
                        scoreList.add(response.body().data.detail.get(i).score);
                    }

                    initPoker(detailResponses.get(0).card,imageViewList);
                    bt_player_1.setText("玩家"+idList.get(0));
                    bt_player_2.setText("玩家"+idList.get(1));
                    bt_player_3.setText("玩家"+idList.get(2));
                    bt_player_4.setText("玩家"+idList.get(3));
                    bt_player_1.setBackgroundColor(Color.GRAY);

                    tv_score.setText(scoreList.get(0)+" ");
                }

            }

            @Override
            public void onFailure(Call<DetailData> call, Throwable t) {

            }
        });

        bt_player_1.setOnClickListener(v -> {
            String[] card = detailResponses.get(0).card;
            initPoker(card,imageViewList);
            tv_score.setText(String.valueOf(scoreList.get(0)));
            bt_player_1.setBackgroundColor(Color.GRAY);
            bt_player_2.setBackground(d);
            bt_player_3.setBackground(d);
            bt_player_4.setBackground(d);
        });
        bt_player_2.setOnClickListener(v -> {
            String[] card = detailResponses.get(1).card;
            initPoker(card,imageViewList);
            tv_score.setText(String.valueOf(scoreList.get(1)));
            bt_player_2.setBackgroundColor(Color.GRAY);
            bt_player_1.setBackground(d);
            bt_player_3.setBackground(d);
            bt_player_4.setBackground(d);
        });
        bt_player_3.setOnClickListener(v -> {
            String[] card = detailResponses.get(2).card;
            initPoker(card,imageViewList);
            tv_score.setText(String.valueOf(scoreList.get(2)));
            bt_player_3.setBackgroundColor(Color.GRAY);
            bt_player_2.setBackground(d);
            bt_player_1.setBackground(d);
            bt_player_4.setBackground(d);
        });
        bt_player_4.setOnClickListener(v -> {
            String[] card = detailResponses.get(3).card;
            initPoker(card,imageViewList);
            tv_score.setText(String.valueOf(scoreList.get(3)));
            bt_player_4.setBackgroundColor(Color.GRAY);
            bt_player_2.setBackground(d);
            bt_player_1.setBackground(d);
            bt_player_3.setBackground(d);
        });

        Button returnButton = findViewById(R.id.return_details);
        returnButton.setOnClickListener(v -> finish());

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
            int resourceId = resources.getIdentifier(
                    name, "drawable",
                    this.getPackageName());
            Drawable drawable = resources.getDrawable(resourceId, null);
            Glide.with(this).load(drawable).into(imageViews.get(i));
        }
    }

}
