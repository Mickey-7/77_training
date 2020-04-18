package com.company.Array_EMS;

import java.util.Arrays;

public class Supervisor {
    private Long id;
    private String name;
    //array of workers
    private Worker[] workers;

    public Supervisor(){}

    public Supervisor(Long id, String name, Worker[] workers) {
        this.id = id;
        this.name = name;
        this.workers = workers;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", workers=" + Arrays.toString(workers) +
                '}';
    }
}
