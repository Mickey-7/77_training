package com.example.day22_ThymeLeaf_Part2.domain;

public class Student {
    private Long id;
    private String name;
    private Double grade;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    public Student(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Student(Long id, String name, Double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}
