package com.company.Exercise;

import java.io.Serializable;
import java.time.LocalDateTime;


//need to implements Serializable and Comparable for ObjectOutputInputStream and Sorting (compareTo() method) respectively
public class Student implements Serializable,Comparable<Student> {
    private Long id;
    private String name;
    private Double grade;
    private LocalDateTime createDateTime;
    private LocalDateTime updateDateTime;

    public Student(){}

    public Student(Long id, String name, Double grade, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

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

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                '}';
    }

    @Override
    public int compareTo(Student student) {
        //use this for the first object and
        //the input parameter student ofr the second object
        return (int) (this.getGrade()-student.getGrade());
    }
}
