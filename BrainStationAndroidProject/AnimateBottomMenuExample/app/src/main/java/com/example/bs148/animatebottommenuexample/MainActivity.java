package com.example.bs148.animatebottommenuexample;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.cocosw.bottomsheet.BottomSheet;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAndroidBottomMenu(View view) {

        new BottomSheet.Builder(this).title("Bottom Menu Title").sheet(R.menu.android_bottom_menu_item).listener(new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case R.id.menu_help:
                        Toast.makeText(MainActivity.this,"Help Click",Toast.LENGTH_LONG).show();
                        // TODO when help menu/button is clicked
                        break;
                    case R.id.menu_call:
                        Toast.makeText(MainActivity.this,"Call Click",Toast.LENGTH_LONG).show();
                        // TODO when call menu/button is clicked
                        break;
                    case R.id.menu_upload:
                        Toast.makeText(MainActivity.this,"Upload Click",Toast.LENGTH_LONG).show();
                        // TODO when upload menu/button is clicked
                        break;
                    case R.id.menu_share:
                        Toast.makeText(MainActivity.this,"Share Click",Toast.LENGTH_LONG).show();
                        // TODO when share menu/button is clicked
                        break;
                }
            }
        }).show();
    }
}
