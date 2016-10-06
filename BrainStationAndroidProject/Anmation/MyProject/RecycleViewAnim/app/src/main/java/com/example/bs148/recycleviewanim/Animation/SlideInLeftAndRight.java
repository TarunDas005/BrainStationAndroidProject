package com.example.bs148.recycleviewanim.Animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by BS148 on 9/23/2016.
 */
public class SlideInLeftAndRight {
    public static void slideInLeft(RecyclerView.ViewHolder holder){
        AnimatorSet animatorSet=new AnimatorSet();
        ObjectAnimator animator=ObjectAnimator.ofFloat(holder.itemView, "translationX", -holder.itemView.getRootView().getWidth(), 0);
        animatorSet.setDuration(1000);
        animatorSet.playTogether(animator);
        animatorSet.start();
    }
    public static void slideInRight(RecyclerView.ViewHolder holder){
        AnimatorSet animatorSet=new AnimatorSet();
        ObjectAnimator animator=ObjectAnimator.ofFloat(holder.itemView, "translationX", holder.itemView.getRootView().getWidth(), 0);
        animatorSet.setDuration(1000);
        animatorSet.playTogether(animator);
        animatorSet.start();
    }
}
