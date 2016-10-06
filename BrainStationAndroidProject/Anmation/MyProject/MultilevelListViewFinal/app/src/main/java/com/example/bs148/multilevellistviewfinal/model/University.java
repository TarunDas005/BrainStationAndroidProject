package com.example.bs148.multilevellistviewfinal.model;

import java.util.ArrayList;

/**
 * Created by BS148 on 9/27/2016.
 */

public class University {
    private String universityName;
    ArrayList<Department> departments;

    public University(String universityName, ArrayList<Department> departments) {
        this.universityName = universityName;
        this.departments = departments;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }
}
