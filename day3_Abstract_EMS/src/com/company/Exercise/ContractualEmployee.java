package com.company.Exercise;

public class ContractualEmployee extends Employee {


    public ContractualEmployee(Long id, String name, Double salary) {
        super(id, name, salary*0.92);
    }

    @Override
    public double getNetSalary() {
        double salary = 0;
        return salary*0.92;
    }


}
