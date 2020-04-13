package com.example.day29_FullStack.service;

import com.example.day29_FullStack.domain.Employee;
import com.example.day29_FullStack.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    //getAllEmployee
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    //getEmployeeById
    public Employee getEmployeeById(Long id){
        //.findById(Long id) -> output : Optional<Employee>
        return employeeRepository.findById(id).orElse(null);
    }

    //addEmployee
    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    //editEmployee
    public Employee editEmployee(Long id, Employee employee){
        //on employeeRepository -> use findById then map and save the updated employee
        employeeRepository.findById(id).map(employee1 -> {
//            employee1.setId(employee.getId());
            employee1.setFirstName(employee.getFirstName());
            employee1.setLastName(employee.getLastName());
            employee1.setGender(employee.getGender());
            employee1.setSalary(employee.getSalary());
            employee1.setResigned(employee.getResigned());
            return employeeRepository.save(employee1);
        });
        return null;
    }

    //deleteEmployee
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }
}
