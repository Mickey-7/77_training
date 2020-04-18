package com.company.Exercise.Sort;

public class Worker extends Employee {
    public Worker(long id, String name) {
        super(id, name);
    }

    //return should be worker fro employee type
    @Override
    public String getEmployeeType() {
        return "worker";
    }
}
