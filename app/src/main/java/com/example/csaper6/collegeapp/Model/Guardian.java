package com.example.csaper6.collegeapp.Model;

/**
 * Created by csaper6 on 2/10/17.
 */
public class Guardian extends Person {
    private String occupation;
    private int age;

    public Guardian()
    {
        firstName = "Bob";
        lastName = "Bobertson";
        occupation = "Blob inspector";
        age = -50;

    }

    public Guardian(String job, int age) {
        this.occupation = job;
        this.age = age;
    }

    public Guardian(String firstName, String lastName, String job, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.occupation = job;
        this.age = age;
    }

    public String getOccupation(){
        return occupation;
    }

    @Override
    public int getAge(){
        return age;
    }

}
