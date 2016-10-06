package com.example.bs148.animationfromandroidhive;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CrossFadeActivity extends AppCompatActivity implements Animation.AnimationListener{
    private TextView fadeInTextView, fadeOutTextView;
    private Button crossFadeStartButton;
    Animation animFadeIn, animFadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cross_fade);
        crossFadeStartButton = (Button) findViewById(R.id.crossFadeStartButtonButton);
        fadeInTextView = (TextView) findViewById(R.id.fadeInTextView);
        fadeOutTextView = (TextView) findViewById(R.id.fadeOutTextView);

        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_out);

        crossFadeStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fadeOutTextView.setVisibility(View.VISIBLE);
                fadeOutTextView.startAnimation(animFadeOut);
                fadeInTextView.setVisibility(View.VISIBLE);
                fadeInTextView.startAnimation(animFadeIn);
            }
        });

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
