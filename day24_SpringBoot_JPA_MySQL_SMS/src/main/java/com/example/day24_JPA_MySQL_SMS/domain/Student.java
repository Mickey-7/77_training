package com.example.day24_JPA_MySQL_SMS.domain;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double grade;
    @OneToOne
    private Address address;
    //many student to one teacher
    @ManyToOne
    private Teacher teacher;

    public Student(){}

    public Student(Long id, String name, Double grade, Address address, Teacher teacher) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.address = address;
        this.teacher = teacher;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", address='" + address + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
