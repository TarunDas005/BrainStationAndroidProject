package com.example.bs148.animationfromandroidhive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FadeInActivity extends AppCompatActivity implements Animation.AnimationListener{

    private TextView fadeInTextView;
    private Button fadeInStartButton;
    Animation animFadeIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fade_in);
        fadeInStartButton= (Button) findViewById(R.id.fadeInStartButton);
        fadeInTextView= (TextView) findViewById(R.id.fadeInTextView);
        fadeInTextView.setVisibility(View.GONE);
        animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animFadeIn.setAnimationListener(this);
        fadeInStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        if(animation==animFadeIn){
            Toast.makeText(getApplicationContext(),"Animation Stopped",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
