package com.example.bs148.multilevellistviewfinal.mapping;

import com.example.bs148.multilevellistviewfinal.UniversityInformationProvier;
import com.example.bs148.multilevellistviewfinal.model.Department;
import com.example.bs148.multilevellistviewfinal.model.Student;
import com.example.bs148.multilevellistviewfinal.model.StudentInformation;
import com.example.bs148.multilevellistviewfinal.model.University;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BS148 on 10/2/2016.
 */

public class StudentAndInformationMapping {
    public static HashMap<String,StudentInformation> getStudentAndInformation(String universityName, String departmentName){
        HashMap<String,StudentInformation> studentAndInformations=new HashMap<String,StudentInformation>();
        ArrayList<University> universities=new ArrayList<University>();
        universities= UniversityInformationProvier.getAllUniversityInformation();
        ArrayList<Student> students=new ArrayList<Student>();
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
        for(Department department:departments){
            if(department.getDepartmentName().equals(departmentName)){
                students=department.getStudents();
            }
        }

        if (students==null)
            return null;

        for(Student student:students){
            studentAndInformations.put(student.getStudentName(),student.getStudentInformation());
        }
        return  studentAndInformations;
    }

    public static ArrayList<String> getSpecificStudentsName(String universityName, String departmentName){
        ArrayList<University> universities=new ArrayList<University>();
        universities= UniversityInformationProvier.getAllUniversityInformation();
        ArrayList<Student> students=new ArrayList<Student>();
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
        for(Department department:departments){
            if(department.getDepartmentName().equals(departmentName)){
                students=department.getStudents();
            }
        }

        if (students==null)
            return null;

        ArrayList<String> studentsName=new ArrayList<String>();
        for (Student student:students){
            studentsName.add(student.getStudentName());
        }
        return studentsName;
    }
}
