package com.example.day29_FullStack.service;

import com.example.day29_FullStack.domain.Employee;
import com.example.day29_FullStack.domain.Supervisor;
import com.example.day29_FullStack.repository.EmployeeRepository;
import com.example.day29_FullStack.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupervisorService {
    private SupervisorRepository supervisorRepository;
    //for addEmployeeToSupervisor
    private EmployeeRepository employeeRepository;
    @Autowired
    public SupervisorService(SupervisorRepository supervisorRepository, EmployeeRepository employeeRepository){
        this.supervisorRepository = supervisorRepository;
        this.employeeRepository = employeeRepository;
    }

    //getAllEmployee
    public List<Supervisor> getAllSupervisor(){
        return supervisorRepository.findAll();
    }

    //getEmployeeById
    public Supervisor getSupervisorById(Long id){
        //.findById(Long id) -> output : Optional<Employee>
        return supervisorRepository.findById(id).orElse(null);
    }

    //addEmployee
    public void addSupervisor(Supervisor supervisor){
        supervisorRepository.save(supervisor);
    }

    //editEmployee
    public Supervisor editSupervisor(Long id, Supervisor supervisor){
        //on employeeRepository -> use findById then map and save the updated employee
        supervisorRepository.findById(id).map(supervisor1 -> {
//            employee1.setId(employee.getId());
            supervisor1.setFirstName(supervisor.getFirstName());
            supervisor1.setLastName(supervisor.getLastName());
            supervisor1.setGender(supervisor.getGender());
            return supervisorRepository.save(supervisor1);
        });
        return null;
    }

    //deleteEmployee
    public void deleteSupervisor(Long id){
        supervisorRepository.deleteById(id);
    }

    //addEmployeeToSupervisor
    public Employee addEmployeeToSupervisor(Long supId, Long empId){
        //storage for employee
        Employee employee = employeeRepository.findById(empId).orElse(null);
        //on supervisorRepository we will use
        //.findById(Long id) -> output : Optional<Employee>
        //.map() and inside .map() we use .getEmployees() -> output : List<Employee>
        //followed by .add(Employee employee) -> output : boolean
        //lastly is to .save() then .getEmployees()
        supervisorRepository.findById(supId).map(supervisor -> {
            supervisor.getEmployees().add(employee);
            return supervisorRepository.save(supervisor).getEmployees();
        });
        return null;
    }
}
