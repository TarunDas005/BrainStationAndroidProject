package com.example.bs148.multilevellistviewfinal;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.example.bs148.multilevellistviewfinal.adapter.UniversityAdapter;
import com.example.bs148.multilevellistviewfinal.mapping.UniversityDepartmentMapping;
import com.example.bs148.multilevellistviewfinal.model.Department;
import com.example.bs148.multilevellistviewfinal.model.University;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    HashMap<String,ArrayList<Department>> universityAndDepartment;
    ExpandableListView universityNameExpandableListView;
    private ArrayList<University> universities;
    ArrayList<String> universityName;
    UniversityAdapter universityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        universityNameExpandableListView= (ExpandableListView) findViewById(R.id.universityExpandableListView);
        universities=new ArrayList<University>();
        universities=UniversityInformationProvier.getAllUniversityInformation();
        HashMap<String,ArrayList<Department>> universityAndDepartment=new HashMap<String, ArrayList<Department>>();
        universityAndDepartment= UniversityDepartmentMapping.getUniversityDepartmentMap(universities);
        universityName=new ArrayList<String>();
        for(University university:universities){
            universityName.add(university.getUniversityName());
        }

        universityAdapter=new UniversityAdapter(getApplicationContext(),universityName,universityAndDepartment);
        universityNameExpandableListView.setAdapter(universityAdapter);

    }
}
