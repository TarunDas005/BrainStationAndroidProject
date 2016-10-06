package com.example.bs148.recycleviewanim.Animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.example.bs148.recycleviewanim.R;

import java.util.Collection;

import jp.wasabeef.recyclerview.animators.BaseItemAnimator;
import jp.wasabeef.recyclerview.animators.FlipInTopXAnimator;

/**
 * Created by BS148 on 9/23/2016.
 */
public class FlipAnimation {
    public static void slideInLeft(Context context,RecyclerView.ViewHolder holder){
//        AnimatorSet animation= (AnimatorSet) AnimatorInflater.loadAnimator(context,R.animator.image_in_left);
//        animation.setTarget(holder.itemView);
//        animation.start();
        /*RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1000);
        rotate.setInterpolator(new LinearInterpolator());
        holder.itemView.startAnimation(rotate);*/


    }
    public static void slideInRight(RecyclerView.ViewHolder holder){
//        RotateAnimation rotate = new RotateAnimation(360,0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        rotate.setDuration(1000);
//        rotate.setInterpolator(new LinearInterpolator());
//        holder.itemView.startAnimation(rotate);
    }
}
