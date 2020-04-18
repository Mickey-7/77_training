package com.company.Exercise.Sort;

import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //create an Employee abstract class with fields id, name and abstract method getEmployeeType and implements Comparable(sort by id)
        //create Manager and Worker (both extending Employee)
            //Employee Type: Manager - "manager", Worker - "worker"
        //create Main class
            //create method for generating Employee (params: id, name, type)
            //generate 3 manager and 3 workers and store in a single array
        //Sort array using Arrays.sort(), print sorted array
        //Sort array via last name using Arrays.sort(), print sorted array

        //generate arrayList for managers and workers
        //need to declare it here to become applied globally
        ArrayList<Employee> employees = new ArrayList<>(
                //multiple addition on arrayList
                Arrays.asList(
                        new Manager(2, "manager1"),
                        new Manager(3, "manager2"),
                        new Manager(1, "manager3"),
                        new Worker(2, "worker3"),
                        new Worker(3, "worker1"),
                        new Worker(1, "worker2")
                )
        );

        //generate array for managers and workers
        //not used for this program - only for array reference for item 2 & 3
//        Employee[] employees = new Employee[]{
//                new Manager(2, "manager1"),
//                new Manager(3, "manager2"),
//                new Manager(1, "manager3"),
//                new Worker(2, "worker3"),
//                new Worker(3, "worker1"),
//                new Worker(1, "worker2")
//        };

        System.out.println("what would you like to do?\n" +
                "1) add employee\n" +
                "2) sort by id\n" +
                "3) sort by name\n" +
                "4) exit");
        int toDo = scanner.nextInt();

        boolean status = true;
        while (status) {
            while (toDo == 1) {
                System.out.println("enter employee id:");
                long empId = scanner.nextLong();
                System.out.println("enter employee name:");
                String empName = scanner.next();
                System.out.println("enter employee type:\n" +
                        "1) Manager\n" +
                        "2) Worker");
                int empType = scanner.nextInt();

                if (empType == 1) {
                    //set the fields to manager
                    Employee manager = new Manager(empId, empName);
                    System.out.println(manager.getEmployeeType());
                    //add the manger to employees arrayList
                    employees.add(manager);
                    System.out.println(manager + " added to Manager");
                } else if (empType == 2) {
                    //set fields to worker
                    Employee worker = new Worker(empId, empName);
                    System.out.println(worker.getEmployeeType());
                    //add worker to employees arrayList
                    employees.add(worker);
                    System.out.println(worker + " added to Worker");
                } else {
                    System.out.println("Type not found!");
                }
                System.out.println(employees);

                System.out.println("what would you like to do?\n" +
                        "1) add employee\n" +
                        "2) sort by id\n" +
                        "3) sort by name\n" +
                        "4) exit");
                toDo = scanner.nextInt();
                break;
            }
            while (toDo == 2){
                //for array sort
//                Arrays.asList(employees);

                //for arrayList sort by id
                Collections.sort(employees);
                System.out.println(employees);

                System.out.println("what would you like to do?\n" +
                    "1) add employee\n" +
                    "2) sort by id\n" +
                    "3) sort by name\n" +
                    "4) exit");
                toDo = scanner.nextInt();
                break;
            }
            while (toDo==3){
                //for array only
//                Arrays.sort(employees,((employee, t1) -> {
//                    return employee.getName().compareTo(t1.getName());
//                }));

                //for arrayList sort by name
                employees.sort(((employee, t1) -> {
                    return employee.getName().compareTo(t1.getName());
                }));
                //System.out.println(employees); output [Lcom.company.Exercise.Sort.Employee;@7eda2dbb
                //so we need to use Arrays.toString() method
                System.out.println(employees);

                System.out.println("what would you like to do?\n" +
                        "1) add employee\n" +
                        "2) sort by id\n" +
                        "3) sort by name\n" +
                        "4) exit");
                toDo = scanner.nextInt();
                break;
            }
            while (toDo==4){
                System.out.println("exiting program......!");
                status = false;
                break;
            }
        }
    }
}
