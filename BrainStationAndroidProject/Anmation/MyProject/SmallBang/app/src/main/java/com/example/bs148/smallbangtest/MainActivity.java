package com.example.bs148.smallbangtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import xyz.hanks.library.SmallBang;
import xyz.hanks.library.SmallBangListener;

public class MainActivity extends AppCompatActivity {
    private SmallBang mSmallBang;
    private Button clickButton;
    private ImageView imageView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        clickButton = (Button) findViewById(R.id.clickButton);
        imageView = (ImageView) findViewById(R.id.imageView);
        textView = (TextView) findViewById(R.id.helloTextView);
        mSmallBang = SmallBang.attach2Window(this);
        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSmallBang.bang(view, new SmallBangListener() {
                    @Override
                    public void onAnimationStart() {
                    }

                    @Override
                    public void onAnimationEnd() {
                        //toast("button +1");
                        startActivity(new Intent(MainActivity.this,AnotherActivity.class));
                    }
                });
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSmallBang.bang(view);
                mSmallBang.setmListener(new SmallBangListener() {
                    @Override
                    public void onAnimationStart() {
                    }

                    @Override
                    public void onAnimationEnd() {
                        toast("heart+1");
                    }
                });
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setTextColor(0xFFCD8BF8);
                mSmallBang.bang(view, 50, new SmallBangListener() {
                    @Override
                    public void onAnimationStart() {
                    }

                    @Override
                    public void onAnimationEnd() {
                        toast("text+1");
                    }
                });
            }
        });
    }
    private void toast(String text) {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }
}
