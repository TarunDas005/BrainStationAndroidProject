package com.example.bs148.multilevellistviewfinal.mapping;


import com.example.bs148.multilevellistviewfinal.model.Department;
import com.example.bs148.multilevellistviewfinal.model.University;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BS148 on 9/29/2016.
 */

public class UniversityDepartmentMapping {
    public static HashMap<String,ArrayList<Department>> getUniversityDepartmentMap(ArrayList<University> universities){
        HashMap<String,ArrayList<Department>> universityAndDepartment=new HashMap<String, ArrayList<Department>>();
        for (University university:universities){
            universityAndDepartment.put(university.getUniversityName(),university.getDepartments());
        }
        return universityAndDepartment;
    }
}
