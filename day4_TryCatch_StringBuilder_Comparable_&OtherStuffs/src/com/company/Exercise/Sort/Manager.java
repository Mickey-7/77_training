package com.company.Exercise.Sort;

public class Manager extends Employee {

    public Manager(long id, String name) {
        super(id, name);
    }

    //return should be manager for employee type
    @Override
    public String getEmployeeType() {
        return "manager";
    }

}
