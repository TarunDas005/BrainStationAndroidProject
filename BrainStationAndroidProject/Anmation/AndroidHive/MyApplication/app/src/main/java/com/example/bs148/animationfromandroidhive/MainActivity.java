package com.example.bs148.animationfromandroidhive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button fadeInButton,fadeOutButton,crossFadeButton,blinkButton,zoomInButton,zoomOutButton,rotateButton,moveButton,slideUpButton,slideDownButton;
    private Button bounceButton,sequentialButton,togetherButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fadeInButton= (Button) findViewById(R.id.fadeInButton);
        fadeOutButton= (Button) findViewById(R.id.fadeOutButton);
        crossFadeButton= (Button) findViewById(R.id.crossFadeButton);
        blinkButton= (Button) findViewById(R.id.blinkButton);
        zoomInButton= (Button) findViewById(R.id.zoomInButton);
        zoomOutButton= (Button) findViewById(R.id.zoomOutButton);
        rotateButton= (Button) findViewById(R.id.rotateButton);
        moveButton= (Button) findViewById(R.id.moveButton);
        slideUpButton= (Button) findViewById(R.id.slideUpButton);
        slideDownButton= (Button) findViewById(R.id.slideDownButton);
        bounceButton= (Button) findViewById(R.id.bounceButton);
        sequentialButton= (Button) findViewById(R.id.sequentialButton);
        togetherButton= (Button) findViewById(R.id.togetherButton);
        fadeInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FadeInActivity.class));
            }
        });
        fadeOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,FadeOutActivity.class));
            }
        });
        crossFadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CrossFadeActivity.class));
            }
        });
        blinkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BlinkActivity.class));
            }
        });
        zoomInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ZoomInActivity.class));
            }
        });
        zoomOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,ZoomOutActivity.class));
            }
        });
        rotateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RotateActivity.class));
            }
        });
        moveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MoveActivity.class));
            }
        });
        slideUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SlideUpActivity.class));
            }
        });
        slideDownButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SlideDownActivity.class));
            }
        });
        bounceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,BounceActivity.class));
            }
        });
        sequentialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SequentialActivity.class));
            }
        });
        togetherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TogetherActivity.class));
            }
        });
    }
}
