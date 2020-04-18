package com.company.WriteToCSV;

import java.io.Serializable;

//encountering error below on OOS class
//Exception in thread "main" java.io.NotSerializableException: com.company.WriteToCSV.Student
//need to implements Serializable
public class Student implements Serializable {
    private long id;
    private String name;
    private double grade;

    public Student(){}

    public Student(long id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
