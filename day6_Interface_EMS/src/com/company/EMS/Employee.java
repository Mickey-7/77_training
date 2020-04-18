package com.company.EMS;

public class Employee {
    private long id;
    private String name;
    private double salary;
    private String managerName;

    public Employee(){}

    public Employee(long id, String name, double salary, String managerName) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.managerName = managerName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        //modified format to conform on CSV
        return id+ "," +name+ "," +salary+ "," +managerName;
    }
}
