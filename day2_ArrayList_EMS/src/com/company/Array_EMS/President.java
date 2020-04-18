package com.company.Array_EMS;

import java.util.Arrays;

public class President {
    private Long id;
    private String name;
    //array of supervisors
    private Supervisor[] supervisors;

    public President(){}

    //alt + insert - constructor
    public President(Long id, String name, Supervisor[] supervisors) {
        this.id = id;
        this.name = name;
        this.supervisors = supervisors;
    }

    //alt + insert - toString()
    @Override
    public String toString() {
        return "President{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", supervisors=" + Arrays.toString(supervisors) +
                '}';
    }
}
