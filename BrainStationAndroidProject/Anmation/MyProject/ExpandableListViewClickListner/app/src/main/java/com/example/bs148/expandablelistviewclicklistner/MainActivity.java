package com.example.bs148.expandablelistviewclicklistner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    HashMap<String,ArrayList<ChildClass>> moviesCategory;
    ArrayList<ChildClass> Movies_Sub_List;
    ExpandableListView expandableListView;
    ArrayList<String> Movies_List;
    MoviesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesCategory=new HashMap<String, ArrayList<ChildClass>>();
        expandableListView= (ExpandableListView) findViewById(R.id.expandableListView);
        moviesCategory=DataProvider.getInfo();
        Movies_List=new ArrayList<String>(moviesCategory.keySet());
        adapter=new MoviesAdapter(this,moviesCategory,Movies_List);
        expandableListView.setAdapter(adapter);

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),Movies_List.get(groupPosition)+" is expanded",Toast.LENGTH_LONG).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),Movies_List.get(groupPosition)+" is collapsed",Toast.LENGTH_LONG).show();
            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ChildClass childClass=moviesCategory.get(Movies_List.get(groupPosition)).get(childPosition);
                Toast.makeText(getApplicationContext(),childClass.getName()+" is Selected from category "+Movies_List.get(groupPosition),Toast.LENGTH_SHORT).show();
                return false;
            }
        });

    }
}
