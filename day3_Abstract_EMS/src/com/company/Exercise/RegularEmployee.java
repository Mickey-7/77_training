package com.company.Exercise;

public class RegularEmployee extends Employee {

    public RegularEmployee(Long id, String name, Double salary) {
        super(id, name, salary*0.8);
    }

    @Override
    public double getNetSalary() {
        double salary = 0;
        return salary*0.8;
    }


}
