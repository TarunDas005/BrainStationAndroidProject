package com.example.bs148.customtoastdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void customToastClick(View view) {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.my_custom_toast, (ViewGroup) findViewById(R.id.custom_toast_layout));
        TextView text = (TextView) layout.findViewById(R.id.textToShow);
        text.setText("My Custom Toast in Center of Screen");
        Toast toast = new Toast(getApplicationContext());
        //2nd parameter hosse xAxis a kototuku padding hobe and 3rd parameter hosse yAxis a kototuku paddingg hobe
        toast.setGravity(Gravity.BOTTOM, 0, 50);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();

    }
}
