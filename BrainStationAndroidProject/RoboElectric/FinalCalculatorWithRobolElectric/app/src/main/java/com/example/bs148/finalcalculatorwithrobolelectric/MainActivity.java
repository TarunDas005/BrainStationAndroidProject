package com.example.bs148.finalcalculatorwithrobolelectric;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText firstNumberEditText,secondNumberEditText;
    private Button addButton,subButton;
    private TextView resultTextView;
    private double firstNumber,secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumberEditText= (EditText) findViewById(R.id.firstNumberEditText);
        secondNumberEditText= (EditText) findViewById(R.id.secondNumberEditText);
        addButton= (Button) findViewById(R.id.addButton);
        subButton= (Button) findViewById(R.id.subButton);
        resultTextView= (TextView) findViewById(R.id.resultTextView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue();
                double res=firstNumber+secondNumber;
                showResult(res+"");
            }
        });
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double res=firstNumber-secondNumber;
                showResult(res+"");
            }
        });
    }


    private void getValue(){
        if(isEmpty())
            Toast.makeText(this,"Field Can not be Empty",Toast.LENGTH_LONG).show();
        else
        {
            firstNumber=Double.parseDouble(firstNumberEditText.getText().toString());
            secondNumber=Double.parseDouble(secondNumberEditText.getText().toString());
        }
    }

    private boolean isEmpty(){
        if(firstNumberEditText.getText().toString().equals("") || secondNumberEditText.getText().toString().equals(""))
            return true;
        else
            return false;
    }

    private void showResult(String res){
        resultTextView.setText(res);
    }
}
