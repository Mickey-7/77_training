package com.company.Exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //create arrayList of employees
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int toDo;

    public static void main(String[] args) {

        //Exercise - Abstract
        //Employee
            //id, name, salary
            //(abstract method) getNetSalary
        //ContractualEmployee
            //netSalary = salary*0.92
        //RegularEmployee
            //netSalary = salary*0.8
        //Main
            //Add employee: basic fields and employee type
            //Remove employee by id
            //Display list of employees
            //Get employee type by id

        System.out.println("What would you like to do?\n" +
                "1) Add Employee\n" +
                "2) Remove Employee\n" +
                "3) Display Employees\n" +
                "4) Get Employee Type\n" +
                "5) Exit");
        int toDo = scanner.nextInt();

        boolean status = true;
        while (status){
            while (toDo==1){
                AddEmployee();
                toDo = scanner.nextInt();
                break;
            }
            while (toDo==2){
                DeleteEmployee();
                toDo = scanner.nextInt();
                break;
            }
            while (toDo==3){
                DisplayEmployees();
                toDo = scanner.nextInt();
                break;
            }
            while (toDo==4){
                GetEmployeeType();
                toDo = scanner.nextInt();
                break;
            }
            while (toDo==5){
                System.out.println("Exiting program.......!");
                status=false;
                break;
            }
        }
    }

    private static void AddEmployee(){
        System.out.println("enter employee id: ");
        int empId = scanner.nextInt();
        System.out.println("enter employee name: ");
        String empName = scanner.next();
        System.out.println("enter employee salary: ");
        double empSalary = scanner.nextDouble();
        System.out.println("enter employee type:\n" +
                "1) Contractual\n" +
                "2) Regular");
        int empType = scanner.nextInt();
        if(empType==1){
            Employee contractualEmployee = new ContractualEmployee((long)empId,empName,empSalary);
            employees.add(contractualEmployee);
            System.out.println(contractualEmployee+" added to contractual employee");
        }else if(empType==2){
            Employee regularEmployee = new RegularEmployee((long)empId,empName,empSalary);
            employees.add(regularEmployee);
            System.out.println(regularEmployee+" added to regular employee");
        }else {
            System.out.println("not an option......!");
            System.out.println("please choose again");
            System.out.println("enter employee type:\n" +
                    "1) Contractual\n" +
                    "2) Regular");
            empType = scanner.nextInt();
        }
        System.out.println(employees);

        System.out.println("What would you like to do?\n" +
                "1) Add Employee\n" +
                "2) Remove Employee\n" +
                "3) Display Employees\n" +
                "4) Get Employee Type\n" +
                "5) Exit");
    }

    private static void DeleteEmployee(){
        System.out.println("enter employee id to be removed: ");
        long remId = scanner.nextInt();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(remId)){
                employees.remove(i);
            }else{
                System.out.println("no employee found!");
            }
        }

        System.out.println("What would you like to do?\n" +
                "1) Add Employee\n" +
                "2) Remove Employee\n" +
                "3) Display Employees\n" +
                "4) Get Employee Type\n" +
                "5) Exit");
    }

    private static void DisplayEmployees(){
        System.out.println("Displaying all list of employees");
        System.out.println(employees);

        System.out.println("What would you like to do?\n" +
                "1) Add Employee\n" +
                "2) Remove Employee\n" +
                "3) Display Employees\n" +
                "4) Get Employee Type\n" +
                "5) Exit");
    }

    private static void GetEmployeeType(){
        System.out.println("enter employee id to be classified: ");
        long empId = scanner.nextLong();
        for (Employee employee : employees) {
            //using enhanced forLoop replaces employees.get(i) by employee
            if (employee.getId().equals(empId)) {
                if (employee instanceof ContractualEmployee) {
                    System.out.println("Employee is Contractual");
                } else if (employee instanceof RegularEmployee) {
                    System.out.println("Employee is Regular");
                } else {
                    System.out.println("No Employee Found!");
                }
            }
        }

        System.out.println("What would you like to do?\n" +
                "1) Add Employee\n" +
                "2) Remove Employee\n" +
                "3) Display Employees\n" +
                "4) Get Employee Type\n" +
                "5) Exit");
    }
}
