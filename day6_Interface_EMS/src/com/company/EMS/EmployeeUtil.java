package com.company.EMS;

import java.io.FileNotFoundException;
import java.util.List;

public interface EmployeeUtil {
    //throws DuplicateEmployeeException - make a DuplicateEmployeeException class and use extends Exception
    void addEmployee(String filePath, Employee employee) throws Exception;
    List<Employee> getAllEmployees(String filePath) throws FileNotFoundException;
    //throws EmployeeNotFoundException - make a EmployeeNotFoundException class and use extends Exception
    Employee getEmployeeById(String filePath, long id) throws Exception;
    //throws EmployeeNotFoundException - make a EmployeeNotFoundException class and use extends Exception
    void updateEmployee(String filepath, Employee employee) throws Exception;
    //throws EmployeeNotFoundException - make a EmployeeNotFoundException class and use extends Exception
    void deleteEmployeeById(String filePath, long id) throws Exception;

}
