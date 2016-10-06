package com.example.bs148.animationfromandroidhive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class FadeOutActivity extends AppCompatActivity {
    private TextView fadeOutTextView;
    private Button fadeOutStartButton;
    Animation animFadeIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fade_out);
        fadeOutStartButton= (Button) findViewById(R.id.fadeOutStartButton);
        fadeOutTextView= (TextView) findViewById(R.id.fadeOutTextView);
        animFadeIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        fadeOutStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fadeOutTextView.setVisibility(View.VISIBLE);
                fadeOutTextView.startAnimation(animFadeIn);
            }
        });
    }
}
