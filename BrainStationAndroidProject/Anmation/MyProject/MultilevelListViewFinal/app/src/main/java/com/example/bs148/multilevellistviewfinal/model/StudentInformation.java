package com.example.bs148.multilevellistviewfinal.model;

/**
 * Created by BS148 on 9/27/2016.
 */

public class StudentInformation {
    private String id;
    private String cgpa;

    public StudentInformation(String id, String cgpa) {
        this.id = id;
        this.cgpa = cgpa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }
}
