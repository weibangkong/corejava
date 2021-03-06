package com.kwb.day07;

public class Student extends Person {
    private String major;
    @Override
    public String getDescription() {
        return "a student majoring in "+ this.major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Student(String name, String major) {
        super(name);
        this.major = major;
    }
}
