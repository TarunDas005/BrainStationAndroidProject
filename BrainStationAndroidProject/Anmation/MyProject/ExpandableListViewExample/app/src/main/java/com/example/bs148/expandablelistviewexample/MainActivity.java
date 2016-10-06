package com.example.bs148.expandablelistviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        ArrayList<String> headings = new ArrayList<String>();
        ArrayList<String> L1 = new ArrayList<String>();
        ArrayList<String> L2 = new ArrayList<String>();
        ArrayList<String> L3 = new ArrayList<String>();

        HashMap<String, ArrayList<String>> childLists = new HashMap<String, ArrayList<String>>() ;

        String heading_items[] = getResources().getStringArray(R.array.header_titles);
        String l1[] = getResources().getStringArray(R.array.h1_items);
        String l2[] = getResources().getStringArray(R.array.h2_items);
        String l3[] = getResources().getStringArray(R.array.h3_items);

        for (String title : heading_items){
            headings.add(title);
        }
        for (String title : l1){
            L1.add(title);
        }
        for (String title : l2){
            L2.add(title);
        }
        for (String title : l3){
            L3.add(title);
        }

        childLists.put(headings.get(0),L1);
        childLists.put(headings.get(1),L2);
        childLists.put(headings.get(2),L3);

        MyAdapter myAdapter=new MyAdapter(this,headings,childLists);
        expandableListView.setAdapter(myAdapter);
    }
}
