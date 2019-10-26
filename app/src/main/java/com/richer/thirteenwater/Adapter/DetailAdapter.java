package com.richer.thirteenwater.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.richer.thirteenwater.Activity.DetailsActivity;
import com.richer.thirteenwater.NetWork.DetailResponse;
import com.richer.thirteenwater.NetWork.HistoryResponse;
import com.richer.thirteenwater.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.ViewHolder> {

    private List<DetailResponse> detailResponseList = new ArrayList<>();

    public DetailAdapter(List<DetailResponse> detailResponseList){
        this.detailResponseList = detailResponseList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.detail_item,parent,false);
        DetailAdapter.ViewHolder holder = new DetailAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DetailResponse detail = detailResponseList.get(position);
        holder.id.setText(String.valueOf(detail.player_id));

        String card="";
        for(int i=0;i<detail.card.length;i++){
            card = card+" "+detail.card[i];
        }

        holder.card.setText(card);
    }

    @Override
    public int getItemCount() {
        return detailResponseList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        TextView card;

        public ViewHolder(View view){

            super(view);
            id = view.findViewById(R.id.player_id_detail);
            card = view.findViewById(R.id.card_detail);

        }

    }

}
