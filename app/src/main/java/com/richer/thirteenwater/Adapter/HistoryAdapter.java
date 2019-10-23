package com.richer.thirteenwater.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.richer.thirteenwater.Activity.DetailsActivity;
import com.richer.thirteenwater.Activity.HistoryActivity;
import com.richer.thirteenwater.NetWork.HistoryResponse;
import com.richer.thirteenwater.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<HistoryResponse> historyResponseList = new ArrayList<>();
    String token;

    public HistoryAdapter(List<HistoryResponse> responseList,String token){
        this.historyResponseList = responseList;
        this.token = token;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.history_item,parent,false);
        HistoryAdapter.ViewHolder holder = new HistoryAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HistoryResponse history = historyResponseList.get(position);
        holder.id.setText(history.data.id);
        holder.score.setText(history.score);
        holder.cardView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(),DetailsActivity.class);
            intent.putExtra("id",history.data.id);
            intent.putExtra("token",token);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return historyResponseList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        TextView score;
        CardView cardView;

        public ViewHolder(View view){

            super(view);
            id = view.findViewById(R.id.room_id_history);
            score = view.findViewById(R.id.score_history);
            cardView = view.findViewById(R.id.cardview_history);

        }

    }

}
