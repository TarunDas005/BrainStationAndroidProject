package com.example.bs148.animationfromandroidhive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class BlinkActivity extends AppCompatActivity {
    private TextView fadeInTextView;
    private Button fadeInStartButton;
    Animation animFadeIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blink);
        fadeInStartButton= (Button) findViewById(R.id.fadeInStartButton);
        fadeInTextView= (TextView) findViewById(R.id.fadeInTextView);
        fadeInTextView.setVisibility(View.GONE);
        animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        fadeInStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeInTextView.setVisibility(View.VISIBLE);
                fadeInTextView.startAnimation(animFadeIn);
            }
        });
    }
}
