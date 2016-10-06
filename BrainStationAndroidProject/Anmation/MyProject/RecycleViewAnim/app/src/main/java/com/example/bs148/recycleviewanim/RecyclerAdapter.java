package com.example.bs148.recycleviewanim;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bs148.recycleviewanim.Animation.FlipAnimation;
import com.example.bs148.recycleviewanim.Animation.ScaleInAndUpAnimation;
import com.example.bs148.recycleviewanim.Animation.SlideInLeftAndRight;

import java.util.ArrayList;

/**
 * Created by BS151 on 7/21/2016.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    ArrayList<Player> players = new ArrayList<Player>();
    Context con;
    int previousPosition=0;

    public RecyclerAdapter(Context con, ArrayList<Player> players) {
        this.con = con;
        this.players = players;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        RecyclerViewHolder recyclerViewHolder = null;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.information_layout, parent, false);
        recyclerViewHolder = new RecyclerViewHolder(con, view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Player player = players.get(position);
        holder.imageView.setImageResource(player.getImageId());
        holder.nameTextView.setText(player.getName());
        holder.battingStyleTextView.setText("Bat. style: " + player.getBatingStyle());
        holder.bowlingStyleTextView.setText("Bow. style: " + player.getBowlingStyle());
        holder.battingAverageT20TextView.setText("Bat. Avg(T20): " + player.getBatingAvgInT20() + "");
        holder.battingAverageODITextView.setText("Bat. Avg(ODI): " + player.getBatingAvgInODI() + "");
        holder.bowlingAverageT20TextView.setText("Bow. Avg(T20): " + player.getBowlingAvgInT20() + "");
        holder.bowlingAverageODITextView.setText("Bow. Avg(ODI): " + player.getBowlingAvgInODI() + "");
        holder.roleTextView.setText(player.getRole());

        if(position>previousPosition){
            //ScaleInAndUpAnimation.animateDown(holder);
            FlipAnimation.slideInLeft(con,holder);
        }else{
            //ScaleInAndUpAnimation.animateUp(holder);
            FlipAnimation.slideInRight(holder);
        }
        previousPosition=position;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{
        Context context;
        ImageView imageView;
        TextView nameTextView, battingStyleTextView, bowlingStyleTextView, battingAverageT20TextView, bowlingAverageT20TextView, battingAverageODITextView, bowlingAverageODITextView, roleTextView;

        public RecyclerViewHolder(Context context, View view) {
            super(view);
            this.context = context;
            imageView = (ImageView) view.findViewById(R.id.imageView);
            nameTextView = (TextView) view.findViewById(R.id.nameTextView);
            battingStyleTextView = (TextView) view.findViewById(R.id.battingStyleTextView);
            bowlingStyleTextView = (TextView) view.findViewById(R.id.bowlingStyleTextView);
            battingAverageT20TextView = (TextView) view.findViewById(R.id.battingAverageT20TextView);
            bowlingAverageT20TextView = (TextView) view.findViewById(R.id.bowlingAverageT20TextView);
            battingAverageODITextView = (TextView) view.findViewById(R.id.battingAverageODITextView);
            bowlingAverageODITextView = (TextView) view.findViewById(R.id.bowlingAverageODITextView);
            roleTextView = (TextView) view.findViewById(R.id.roleTextView);
        }
    }

    @Override
    public int getItemCount() {
        return players.size();
    }
}
