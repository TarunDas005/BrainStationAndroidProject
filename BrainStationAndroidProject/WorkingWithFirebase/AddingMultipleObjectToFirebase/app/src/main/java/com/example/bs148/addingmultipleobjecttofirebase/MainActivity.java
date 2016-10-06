package com.example.bs148.addingmultipleobjecttofirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private EditText mValueField;
    private Button mAddButton;
    private EditText mKeyField;

    private Firebase mRootRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRootRef=new Firebase("https://multipleobjecttofirebase.firebaseio.com/Users");
        mValueField= (EditText) findViewById(R.id.valueField);
        mAddButton= (Button) findViewById(R.id.addButton);
        mKeyField=(EditText) findViewById(R.id.keyField);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value=mValueField.getText().toString();


                //set the value of key Name if value already exist then override the value
                /*Firebase childRef=mRootRef.child("Name");
                childRef.setValue(value);*/

                //for create manual key
                /*Firebase childRef=mRootRef.child("Profession");
                childRef.setValue(value);*/

                //root ar against a new value add hobe with random key
                //push always unique id create kore then value push kore
                /*mRootRef.push().setValue(value);*/

                //another way key input from user
                String key=mKeyField.getText().toString();
                Firebase childRef=mRootRef.child(key);
                childRef.setValue(value);

            }
        });
    }
}
