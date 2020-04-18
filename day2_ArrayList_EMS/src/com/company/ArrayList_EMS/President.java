package com.company.ArrayList_EMS;

import java.util.ArrayList;

public class President {
    private Long id;
    private String name;
    private ArrayList<Supervisor> supervisorArrayList;

    public President(){}

    public President(Long id, String name, ArrayList<Supervisor> supervisorArrayList) {
        this.id = id;
        this.name = name;
        this.supervisorArrayList = supervisorArrayList;
    }

    @Override
    public String toString() {
        return "President{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", supervisorList=" + supervisorArrayList +
                '}';
    }
}
