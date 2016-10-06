package com.example.bs148.firebaseretrieverealmdata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private TextView mValueTextView;

    private Firebase mRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for retrieve singlee object
        // mRef=new Firebase("https://fir-retrieverealmdata.firebaseio.com/Name");

        //for retrieve multiple object
        mRef=new Firebase("https://fir-retrieverealmdata.firebaseio.com/");

        mValueTextView= (TextView) findViewById(R.id.valueTextView);

        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //for retrieve single object
                /*String value=dataSnapshot.getValue(String.class);
                mValueTextView.setText(value);*/

                // for retrieve multiple object
                //Log.v("E_VALUE","Data: "+dataSnapshot.getValue());
                Map<String,String> map=dataSnapshot.getValue(Map.class);

                String name=map.get("Name");
                String age=map.get("Age");
                String profession=map.get("Profession");

                Log.v("E_VALUE","Name: "+name);
                Log.v("E_VALUE","Age: "+age);
                Log.v("E_VALUE","Profession: "+profession);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }
}
