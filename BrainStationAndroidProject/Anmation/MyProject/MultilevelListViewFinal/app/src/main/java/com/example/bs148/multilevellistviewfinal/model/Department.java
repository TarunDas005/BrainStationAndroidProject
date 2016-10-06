package com.example.bs148.multilevellistviewfinal.model;

import java.util.ArrayList;

/**
 * Created by BS148 on 9/27/2016.
 */

public class Department {
    private String departmentName;
    ArrayList<Student> students;

    public Department(String departmentName, ArrayList<Student> students) {
        this.departmentName = departmentName;
        this.students = students;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
}
