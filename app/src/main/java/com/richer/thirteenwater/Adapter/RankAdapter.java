package com.richer.thirteenwater.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.richer.thirteenwater.NetWork.RankResponse;
import com.richer.thirteenwater.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RankAdapter extends RecyclerView.Adapter<RankAdapter.ViewHolder> {

    private List<RankResponse> mRankList;

    public RankAdapter(List<RankResponse> rankList){
        mRankList = rankList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rank_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RankResponse rank = mRankList.get(position);
        holder.point.setText(""+rank.getScore());
        holder.name.setText(rank.getName());
        holder.rank.setText(String.valueOf(position+1));
    }

    @Override
    public int getItemCount() {
        return mRankList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView rank;
        TextView name;
        TextView point;

        public ViewHolder(View view){

            super(view);
            rank = view.findViewById(R.id.rank_rank);
            name = view.findViewById(R.id.rank_name);
            point = view.findViewById(R.id.rank_point);

        }

    }

}
