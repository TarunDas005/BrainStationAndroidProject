package com.example.bs148.actswitchdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yellow5a5.actswitchanimtool.ActSwitchAnimTool;

public class FirstActivity extends AppCompatActivity {
    private Button backButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        backButton= (Button) findViewById(R.id.backButton);
        new ActSwitchAnimTool(FirstActivity.this)
                .receiveIntent(getIntent())
                .setAnimType(ActSwitchAnimTool.MODE_SHRINK)
                .target(backButton)
                .build();

    }
}
