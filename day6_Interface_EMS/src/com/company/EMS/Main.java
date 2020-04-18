package com.company.EMS;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    //contains methods
    private static EmployeeUtilities employeeUtilities = new EmployeeUtilities();
    //CSV DB path
    private static String filePath = "C:\\Users\\donat\\Documents\\to be done\\seven_seven_trainings\\day6_Interface_EMS\\src\\com\\company\\EMS\\Employee.txt";
    public static void main(String[] args) throws Exception {

        //EMS:
            // Add Employee,        - access CSV DB
            // Get All Employee     - access CSV DB
            // Get Employee by ID   - access CSV DB
            // Update Employee      - access CSV DB
            // Delete Employee      - access CSV DB
        //Handle headers & reorder columns
        //Throwing of EmployeeNotFoundException and DuplicateEmployeeException should be inside Employee Util methods
        //Sample CSV:
            //id,name,salary,managerName
            //1,john,70000,Doe
            //2,cena,80000,Doe

        //Main class -> EmployeeUtilities (implements EmployeeUtil) -> EmployeeUtil (interface) -> DuplicateEmployeeException & EmployeeNotFoundException class

        employeeUtilities.checkAndWriteToCSV(filePath);

        System.out.println("what would you like to do?\n" +
                "1) Add Employee\n" +
                "2) Get All Employee\n" +
                "3) Get Employee by ID\n" +
                "4) Update Employee\n" +
                "5) Delete Employee\n" +
                "6) Exit");
        int toDo = scanner.nextInt();

        boolean status = true;
        while (status){
            while (toDo==1){
                System.out.println("option1");
                //underline will appear on .addEmployee(filePath,employee) method
                //just hover and add Exception to signature method
                addEmployee();
                toDo=scanner.nextInt();
            }

            while (toDo==2){
                System.out.println("option2");
                getAllEmployee();
                toDo=scanner.nextInt();
            }

            while (toDo==3){
                System.out.println("option3");
                //sout will not work on method below as it returns void
                //so the sout will be inside of the method below
                getEmployeeByID();
                toDo=scanner.nextInt();
            }

            while (toDo==4){
                System.out.println("option4");
                updateEmployee();
                toDo=scanner.nextInt();
            }

            while (toDo==5){
                System.out.println("option5");
                deleteEmployee();
                toDo=scanner.nextInt();
            }

            while (toDo==6){
                System.out.println("exiting program......!");
                status=false;
                break;
            }
        }




    }

    private static void deleteEmployee() throws Exception {
        System.out.println("enter employee id to be deleted: ");
        long empId = scanner.nextLong();
        //calling deleteEmployee method from EmployeeUtilities
        //underline will appear on .deleteEmployeeById(filePath,empId) method
        //just hover and add Exception to signature method
        //so the EmployeeNotFoundException will be displayed on console,
        //if id doesn't exist on the CSV - see EmployeeUtilities
        employeeUtilities.deleteEmployeeById(filePath,empId);


        System.out.println("what would you like to do?\n" +
                "1) Add Employee\n" +
                "2) Get All Employee\n" +
                "3) Get Employee by ID\n" +
                "4) Update Employee\n" +
                "5) Delete Employee\n" +
                "6) Exit");
    }

    private static void updateEmployee() {
        //need to create blank Employee object
        Employee employee = new Employee();
        System.out.println("enter employee id: ");
        long empId = scanner.nextLong();
        System.out.println("what would you like to update:\n" +
                "1) Salary\n" +
                "2) Manager Name");
        int update = scanner.nextInt();
        switch (update){
            case 1:
                System.out.println("enter new salary: ");
                double newSalary = scanner.nextDouble();
                employee.setSalary(newSalary);
                break;
            case 2:
                System.out.println("enter new manager name: ");
                String newManagerName = scanner.next();
                employee.setManagerName(newManagerName);
                break;
            default:
                System.out.println("invalid option");
        }
        //calling updateEmployee method from EmployeeUtilities
        //underline will appear on addEmployee - choose surround with try/catch
        try {
            employeeUtilities.updateEmployee(filePath,employee);
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Error encountered : "+e);
        }

        System.out.println("what would you like to do?\n" +
                "1) Add Employee\n" +
                "2) Get All Employee\n" +
                "3) Get Employee by ID\n" +
                "4) Update Employee\n" +
                "5) Delete Employee\n" +
                "6) Exit");
    }

    private static void getEmployeeByID() throws Exception {
        System.out.println("enter employee id: ");
        long empID = scanner.nextLong();
        //calling getEmployeeByID method from EmployeeUtilities
        //underline will appear on .getEmployeeById(filePath,empId) method
        //just hover and add Exception to signature method
        //so the EmployeeNotFoundException will be displayed on console,
        //if id doesn't exist on the CSV - see EmployeeUtilities
        System.out.println(employeeUtilities.getEmployeeById(filePath,empID));

        System.out.println("what would you like to do?\n" +
                "1) Add Employee\n" +
                "2) Get All Employee\n" +
                "3) Get Employee by ID\n" +
                "4) Update Employee\n" +
                "5) Delete Employee\n" +
                "6) Exit");
    }

    private static void getAllEmployee() {
        //calling getAllEmployee method from EmployeeUtilities
        //underline will appear on addEmployee - choose surround with try/catch
        try {
            System.out.println(employeeUtilities.getAllEmployees(filePath));
        } catch (Exception e) {
//            e.printStackTrace();
            System.out.println("Error encounter : "+e);
        }

        System.out.println("what would you like to do?\n" +
                "1) Add Employee\n" +
                "2) Get All Employee\n" +
                "3) Get Employee by ID\n" +
                "4) Update Employee\n" +
                "5) Delete Employee\n" +
                "6) Exit");
    }

    private static void addEmployee() throws Exception {
        //create blank Employee object
        Employee employee = new Employee();
        System.out.println("enter employee id: ");
        long empId = scanner.nextLong();
        employee.setId(empId);
        System.out.println("enter employee name: ");
        String empName = scanner.next();
        employee.setName(empName);
        System.out.println("enter employee salary: ");
        Double empSalary = scanner.nextDouble();
        employee.setSalary(empSalary);
        System.out.println("enter manager name: ");
        String managerName = scanner.next();
        employee.setManagerName(managerName);
        //calling getAllEmployee method from EmployeeUtilities
        //underline will appear on .addEmployee(filePath,employee) method
        //just hover and add Exception to signature method
        //so the DuplicateEmployeeException will be displayed on console,
        //once id already existed on the CSV - see EmployeeUtilities
        employeeUtilities.addEmployee(filePath,employee);


        System.out.println("what would you like to do?\n" +
                "1) Add Employee\n" +
                "2) Get All Employee\n" +
                "3) Get Employee by ID\n" +
                "4) Update Employee\n" +
                "5) Delete Employee\n" +
                "6) Exit");

    }
}
