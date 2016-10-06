package com.example.bs148.multilevellistviewfinal;

import com.example.bs148.multilevellistviewfinal.model.Department;
import com.example.bs148.multilevellistviewfinal.model.Student;
import com.example.bs148.multilevellistviewfinal.model.StudentInformation;
import com.example.bs148.multilevellistviewfinal.model.University;

import java.util.ArrayList;

/**
 * Created by BS148 on 9/27/2016.
 */

public class UniversityInformationProvier {
    public static ArrayList<University> getAllUniversityInformation(){
        ArrayList<University> universities;
        universities=new ArrayList<University>();
        ArrayList<Student> students=new ArrayList<Student>();
        ArrayList<Department> departments=new ArrayList<Department>();
        StudentInformation studentInformation=new StudentInformation("2012-1-60-005","3.7");
        Student student=new Student("tarun",studentInformation);
        students.add(student);
        studentInformation=new StudentInformation("2013-2-60-014","3.1");
        student=new Student("Jannat",studentInformation);
        students.add(student);
        Department department=new Department("cse",students);
        departments.add(department);


        students=new ArrayList<Student>();
        studentInformation=new StudentInformation("2011-1-80-015","3.8");
        student=new Student("Borun",studentInformation);
        students.add(student);
        studentInformation=new StudentInformation("2014-2-80-114","2.1");
        student=new Student("Kajol",studentInformation);
        students.add(student);
        department=new Department("eee",students);
        departments.add(department);

        University university=new University("EWU",departments);
        universities.add(university);

        students=new ArrayList<Student>();
        departments=new ArrayList<Department>();
        studentInformation=new StudentInformation("2014-1-60-011","3.45");
        student=new Student("ABC",studentInformation);
        students.add(student);
        studentInformation=new StudentInformation("2011-2-60-004","2.14");
        student=new Student("PQR",studentInformation);
        students.add(student);
        department=new Department("cse",students);
        departments.add(department);

        students=new ArrayList<Student>();
        studentInformation=new StudentInformation("2011-1-80-111","1.45");
        student=new Student("MSS",studentInformation);
        students.add(student);
        studentInformation=new StudentInformation("2010-2-80-044","3.14");
        student=new Student("LMN",studentInformation);
        students.add(student);
        department=new Department("ece",students);
        departments.add(department);

        department=new Department("BBA",null);
        departments.add(department);
        university=new University("NSU",departments);
        universities.add(university);

        university=new University("AIUB",null);
        universities.add(university);

        return universities;
    }
}
