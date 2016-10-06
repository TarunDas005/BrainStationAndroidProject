package com.example.bs148.expandablelistviewclicklistner;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by BS148 on 9/26/2016.
 */

public class DataProvider {
    public static HashMap<String,ArrayList<ChildClass>> getInfo(){
        ArrayList<ChildClass> Movies_List=new ArrayList<ChildClass>();
        HashMap<String,ArrayList<ChildClass>> moviesDetail=new HashMap<String, ArrayList<ChildClass>>();
        ArrayList<ChildClass> Action_Movies=new ArrayList<ChildClass>();
        ChildClass am1=new ChildClass("The Dark Knight");
        ChildClass am2=new ChildClass("Heat");
        ChildClass am3=new ChildClass("Inception");
        ChildClass am4=new ChildClass("Kill Bill");
        ChildClass am5=new ChildClass("Gladiator");
        ChildClass am6=new ChildClass("Saving Private Ryan");
        ChildClass am7=new ChildClass("Terminator 2: Judgment Day");
        Action_Movies.add(am1);
        Action_Movies.add(am2);
        Action_Movies.add(am3);
        Action_Movies.add(am4);
        Action_Movies.add(am5);
        Action_Movies.add(am6);
        Action_Movies.add(am7);
        ArrayList<ChildClass> Romantic_Movies=new ArrayList<ChildClass>();
        am1=new ChildClass("Out of Sight");
        am2=new ChildClass("Buffalo");
        am3=new ChildClass("Un Chant d'Amour");
        am4=new ChildClass("The Fabulous Baker Boys");
        am5=new ChildClass("Doctor Zhivago");
        am6=new ChildClass("Cyrano de Bergerac");
        Romantic_Movies.add(am1);
        Romantic_Movies.add(am2);
        Romantic_Movies.add(am3);
        Romantic_Movies.add(am4);
        Romantic_Movies.add(am5);
        Romantic_Movies.add(am6);
        ArrayList<ChildClass> Horror_Movies=new ArrayList<ChildClass>();
        am1=new ChildClass("Orphan");
        am2=new ChildClass("The Ring");
        am3=new ChildClass("You’re Next");
        am4=new ChildClass("It Follows");
        am5=new ChildClass("Berberian Sound Studio");
        am6=new ChildClass("We Are What We Are");
        Horror_Movies.add(am1);
        Horror_Movies.add(am2);
        Horror_Movies.add(am3);
        Horror_Movies.add(am4);
        Horror_Movies.add(am5);
        Horror_Movies.add(am6);
        ArrayList<ChildClass> Comedy_Movies=new ArrayList<ChildClass>();
        am1=new ChildClass("Step Brothers");
        am2=new ChildClass("White Chick");
        am3=new ChildClass("The Hot Chick");
        am4=new ChildClass("The Hangover");
        am5=new ChildClass("Horrible Bosses");
        am6=new ChildClass("Drillbit Taylor");
        Comedy_Movies.add(am1);
        Comedy_Movies.add(am2);
        Comedy_Movies.add(am3);
        Comedy_Movies.add(am4);
        Comedy_Movies.add(am5);
        Comedy_Movies.add(am6);

        moviesDetail.put("Action Movies",Action_Movies);
        moviesDetail.put("Romantic Movies",Romantic_Movies);
        moviesDetail.put("Horror Movies",Horror_Movies);
        moviesDetail.put("Comedy Movies Movies",Comedy_Movies);

        return moviesDetail;

    }
}
