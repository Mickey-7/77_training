package com.company.Exercise;

import java.io.Serializable;
import java.util.List;

//need to implements Serializable  for ObjectOutputInputStream
public class School implements Serializable {
    private Object name;
    private List<Teacher> teachers;

    public School(){}

    public School(Object name, List<Teacher> teachers) {
        this.name = name;
        this.teachers = teachers;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", teachers=" + teachers +
                '}';
    }
}
