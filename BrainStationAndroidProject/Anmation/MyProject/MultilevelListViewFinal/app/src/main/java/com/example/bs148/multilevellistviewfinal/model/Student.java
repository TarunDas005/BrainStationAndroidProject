package com.example.bs148.multilevellistviewfinal.model;

/**
 * Created by BS148 on 9/27/2016.
 */

public class Student {
    private String studentName;
    private StudentInformation studentInformation;

    public Student(String studentName, StudentInformation studentInformation) {
        this.studentName = studentName;
        this.studentInformation = studentInformation;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public StudentInformation getStudentInformation() {
        return studentInformation;
    }

    public void setStudentInformation(StudentInformation studentInformation) {
        this.studentInformation = studentInformation;
    }
}
