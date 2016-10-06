package com.example.bs148.multilevellistviewfinal.mapping;


import com.example.bs148.multilevellistviewfinal.UniversityInformationProvier;
import com.example.bs148.multilevellistviewfinal.model.Department;
import com.example.bs148.multilevellistviewfinal.model.Student;
import com.example.bs148.multilevellistviewfinal.model.University;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BS148 on 9/29/2016.
 */

public class DepartmentAndStuddentMappings {
    public static HashMap<String, ArrayList<Student>> getDepartmentAndStudentMaping(String universityName) {
        HashMap<String, ArrayList<Student>> departmentAndStudents=new HashMap<String, ArrayList<Student>>();
        ArrayList<University> universities = new ArrayList<University>();
        universities= UniversityInformationProvier.getAllUniversityInformation();
        ArrayList<Department> departments=new ArrayList<Department>();
        for(int i=0;i<universities.size();i++){
            if(universities.get(i).getUniversityName().equals(universityName)){
                try {
                    departments=universities.get(i).getDepartments();
                }catch (Exception e){
                    return null;
                }
            }
        }
        if(departments==null)
            return null;

        for(Department  department:departments){
            departmentAndStudents.put(department.getDepartmentName(),department.getStudents());
        }
        return departmentAndStudents;
    }

    public static ArrayList<String> getSpecificDepartmentsName(String universityName){
        ArrayList<String> departmentsName=new ArrayList<String>();
        ArrayList<University> universities = new ArrayList<University>();
        ArrayList<Department> departments=new ArrayList<Department>();
        universities= UniversityInformationProvier.getAllUniversityInformation();
        for(int i=0;i<universities.size();i++){
            if(universities.get(i).getUniversityName().equals(universityName)){
                try {
                    departments=universities.get(i).getDepartments();
                }catch (Exception e){
                    return null;
                }
            }
        }
        if(departments==null)
            return null;
        for(Department  department:departments){
           departmentsName.add(department.getDepartmentName());
        }
        return departmentsName;
    }
}
