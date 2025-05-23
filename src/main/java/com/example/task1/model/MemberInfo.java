package com.example.task1.model;


public class MemberInfo {

    private String fullName;
    private int age;
    private String school;
    private int birthYear;


    public MemberInfo(String fullName, int age, String school, int birthYear) {
        this.fullName = fullName;
        this.age = age;
        this.school = school;
        this.birthYear = birthYear;
    }

    // Getters
    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getSchool() {
        return school;
    }

    public int getBirthYear() {
        return birthYear;
    }
}

