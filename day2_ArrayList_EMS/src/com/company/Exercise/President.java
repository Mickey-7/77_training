package com.company.Exercise;

import java.util.ArrayList;

public class President {
    private Long id;
    private String name;
    private ArrayList<Supervisor> supervisors;

    public President(){}

    public President(Long id, String name, ArrayList<Supervisor> supervisors) {
        this.id = id;
        this.name = name;
        this.supervisors = supervisors;
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

    public ArrayList<Supervisor> getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(ArrayList<Supervisor> supervisors) {
        this.supervisors = supervisors;
    }

    @Override
    public String toString() {
        return "President{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", supervisors=" + supervisors +
                '}';
    }
}
