package com.company.ArrayList_EMS;

import java.util.ArrayList;


public class Supervisor {
    private Long id;
    private String name;
    private ArrayList<Worker> workerArrayList;

    public Supervisor(){}

    public Supervisor(Long id, String name, ArrayList<Worker> workerArrayList) {
        this.id = id;
        this.name = name;
        this.workerArrayList = workerArrayList;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workerList=" + workerArrayList +
                '}';
    }
}
