package com.example.bs148.recycleviewanim;

import android.content.Context;

import java.util.ArrayList;
import java.util.Arrays;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.AnimationAdapter;
import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInRightAnimationAdapter;

/**
 * Created by BS148 on 9/23/2016.
 */
public abstract class DifferentAdapterAnimation {
    static enum Type {
        AlphaIn {
            public AnimationAdapter get(Context context, ArrayList<Player> players) {
                RecyclerAdapter adapter = new RecyclerAdapter(context, players);
                return new AlphaInAnimationAdapter(adapter);
            }
        }, ScaleIn {
            public AnimationAdapter get(Context context, ArrayList<Player> players) {
                RecyclerAdapter adapter = new RecyclerAdapter(context, players);
                return new ScaleInAnimationAdapter(adapter);
            }
        },
        SlideInBottom {
            @Override
            public AnimationAdapter get(Context context, ArrayList<Player> players) {
                RecyclerAdapter adapter = new RecyclerAdapter(context, players);
                return new SlideInBottomAnimationAdapter(adapter);
            }
        },
        SlideInLeft {
            @Override
            public AnimationAdapter get(Context context, ArrayList<Player> players) {
                RecyclerAdapter adapter = new RecyclerAdapter(context, players);
                return new SlideInLeftAnimationAdapter(adapter);
            }
        },
        SlideInRight {
            @Override
            public AnimationAdapter get(Context context, ArrayList<Player> players) {
                RecyclerAdapter adapter = new RecyclerAdapter(context, players);
                return new SlideInRightAnimationAdapter(adapter);
            }
        };

        public abstract AnimationAdapter get(Context context, ArrayList<Player> players);

    }
}
