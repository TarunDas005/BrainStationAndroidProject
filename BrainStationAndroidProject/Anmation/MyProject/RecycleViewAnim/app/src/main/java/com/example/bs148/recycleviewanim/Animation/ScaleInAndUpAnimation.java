package com.example.bs148.recycleviewanim.Animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.widget.RecyclerView;

/**
 * Created by BS148 on 9/23/2016.
 */
public class ScaleInAndUpAnimation {
    public static void animateDown(RecyclerView.ViewHolder holder){
        AnimatorSet animatorSet=new AnimatorSet();
        ObjectAnimator scaleX = ObjectAnimator.ofFloat(holder.itemView, "scaleX", 0.5f, 1f);
        ObjectAnimator scaleY = ObjectAnimator.ofFloat(holder.itemView, "scaleY", 0.5f, 1f);
        animatorSet.setDuration(1000);
        animatorSet.playTogether(scaleX,scaleY);
        animatorSet.start();

    }
    public static void animateUp(RecyclerView.ViewHolder holder){
        AnimatorSet animatorSet=new AnimatorSet();
        ObjectAnimator animatorY=ObjectAnimator.ofFloat(holder.itemView,"translationY",-200,0);
        animatorSet.setDuration(1000);
        animatorSet.playTogether(animatorY);
        animatorSet.start();

    }
}
