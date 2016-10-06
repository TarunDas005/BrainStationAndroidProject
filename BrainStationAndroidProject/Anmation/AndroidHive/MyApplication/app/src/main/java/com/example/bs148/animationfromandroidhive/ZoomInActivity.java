package com.example.bs148.animationfromandroidhive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ZoomInActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button zoomInButton;
    Animation animationZoomIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_in);
        imageView= (ImageView) findViewById(R.id.imageView);
        zoomInButton= (Button) findViewById(R.id.startZoomInButton);
        animationZoomIn= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        zoomInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(animationZoomIn);
            }
        });
    }
}
