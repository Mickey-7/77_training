package com.example.day29_FullStack.controller;

import com.example.day29_FullStack.domain.Employee;
import com.example.day29_FullStack.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
//connecting to FE
@CrossOrigin(origins = "*")
public class EmployeeController {
    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    //getAllEmployee
    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    //getEmployeeById
    @GetMapping("view/{id}")
    public Employee getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    //addEmployee
    @PostMapping
    public void addEmployee(@RequestBody  Employee employee){
        employeeService.addEmployee(employee);
    }

    //editEmployee
    @PutMapping("edit/{id}")
    public Employee editEmployee(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.editEmployee(id,employee);
    }

    //deleteEmployee
    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }
}
