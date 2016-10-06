package com.example.bs148.actswitchdemo;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yellow5a5.actswitchanimtool.ActSwitchAnimTool;

public class MainActivity extends AppCompatActivity {

    private Button firstActivityButton,secondActivityButton;
    ActSwitchAnimTool mFirstDemoActSwitchAnimTool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstActivityButton= (Button) findViewById(R.id.firstActivityButton);
        secondActivityButton= (Button) findViewById(R.id.secondActivityButton);

        firstActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                mFirstDemoActSwitchAnimTool = new ActSwitchAnimTool(MainActivity.this).setAnimType(ActSwitchAnimTool.MODE_SPREAD)
                        .setShrinkBack(true).target(firstActivityButton)
                        .setmColorStart(Color.parseColor("#FF5777"))
                        .setmColorEnd(Color.parseColor("#FF5777"))
                        .startActivity(intent, false);
                mFirstDemoActSwitchAnimTool.setAnimType(ActSwitchAnimTool.MODE_SPREAD)
                        .build();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mFirstDemoActSwitchAnimTool == null)
            return;
        if (mFirstDemoActSwitchAnimTool.isWaitingResume()) {
            mFirstDemoActSwitchAnimTool.setAnimType(1)
                    .setIsWaitingResume(false)
                    .build();
        }


    }

}
