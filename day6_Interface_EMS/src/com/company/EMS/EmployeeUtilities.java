package com.company.EMS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EmployeeUtilities implements EmployeeUtil {
    //create file & Handle headers & reorder columns
    public void checkAndWriteToCSV(String filePath)   {
        File file = new File(filePath);
        //use try-catch instead of throwing exceptions
        try {

            if (!file.exists()){
            file.createNewFile();
                FileWriter  writer = new FileWriter(file);
                writer.write("id,name,salary,managerName\n");
                writer.close();
            }
            else {
                FileWriter  writer = new FileWriter(file);
                writer.write("id,name,salary,managerName\n");
                writer.close();
                System.out.println("File Found!");
            }

        } catch (IOException e) {
            System.out.println("Error encountered : "+e);
        }
    }

    @Override
    public void addEmployee(String filePath, Employee employee) throws Exception {
        //setting arrayList of employees and including the existing employees from CSV
        List<Employee> employees = getAllEmployees(filePath);

        //check for DuplicateEmployeeException
        for(Employee emp : employees){
            if (emp.getId()==employee.getId()){
                throw new DuplicateEmployeeException();
            }
        }

        //writing the employee of the CSV - need to set append:true
        FileWriter writer = new FileWriter(new File(filePath),true);
        //.append(CharSequence csq) -> output Writer
        //so we need to convert employee object to string using .toString()
        //and also concatenate \n so that when we add - it will start on the next line
        writer.append(employee.toString()+"\n");
        writer.close();
        System.out.println(employee);
        //Employee{id=1, name='empOne', salary=10.0, managerName='managerOne'}
        //so we need to modify the toString() method on Employee class - see Employee class
        //so that it will return format like below:
        //1,empOne,10.0,managerOne
    }

    @Override
    public List<Employee> getAllEmployees(String filePath) throws FileNotFoundException {
        //blank arrayList of employees - will be use for storage of employees from CSV
        List<Employee> employees = new ArrayList<>();
        //setting the Scanner reader to scan filePath
        Scanner reader = new Scanner(new File(filePath));
        //need this so that the Scanner reader will skip the first row
        reader.nextLine();
        while (reader.hasNext()){
            //String array value to hold the split value from the file
            String[] value = reader.nextLine().split(",");
            //set employee fields from String array value
            Employee employee = new Employee(
                    //.parseLong(String s) -> output long
                    Long.parseLong(value[0]),
                    value[1],
                    Double.parseDouble(value[2]),
                    value[3]
            );
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(String filePath, long id) throws Exception {
        //directly iterating on the getAllEmployees(filePath) method above
        //as it directly returns List<Employee>
        for(Employee employee : getAllEmployees(filePath)){
            if (employee.getId()==id){
                return employee;
            }
//            //else option which contains throwing of Exception below is not working properly
//            //so it is commented out - option is to make another loop for Exception alone (see below)
//            else {
//                throw new EmployeeNotFoundException();
//            }
        }
        //no idea why throwing Exception needs to have its own loop
        //properly working now with correct output
        List<Employee> employees = getAllEmployees(filePath);
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId()!=id){
                throw new EmployeeNotFoundException();
            }
        }
        //no need for the Scanner to be used as we are already calling
        //the getAllEmployees(filePath) method which utilizes the Scanner
        return null;
    }

    @Override
    public void updateEmployee(String filePath, Employee employee) throws Exception {
        //directly iterating on getAllEmployees(filePath) method -> output List<Employee>
        for (Employee emp : getAllEmployees(filePath)){
            if (emp.getId()==employee.getId()){

            }
            //properly working if throwing Exception is commented out
            //throwing Exception
            else {
                throw new EmployeeNotFoundException();
            }
        }
    }

    @Override
    public void deleteEmployeeById(String filePath, long id) throws Exception {

        getAllEmployees(filePath).removeIf(employee -> employee.getId()==id);
        List<Employee> newEmployeesCSV = new ArrayList<>();
        newEmployeesCSV.addAll(getAllEmployees(filePath));
        for (int i = 0; i < newEmployeesCSV.size(); i++) {
            Employee employee = newEmployeesCSV.get(i);
            newEmployeesCSV.add(employee);
        }
        System.out.println(newEmployeesCSV);



















        //need to create an arrayList where we will add the employee to be deleted
//        List<Employee> newEmployeesCSV = new ArrayList<>();
        //directly iterating on getAllEmployees(filePath) method -> output List<Employee>
//        for (Employee emp : getAllEmployees(filePath)){
//            if (emp.getId()==id){
//
//
//            }
////            //properly working if throwing Exception is commented out
////            //throwing Exception
////            else {
////                throw new EmployeeNotFoundException();
////            }
//        }


    }
}
