package com.example.day29_FullStack.controller;

import com.example.day29_FullStack.domain.Employee;
import com.example.day29_FullStack.domain.Supervisor;
import com.example.day29_FullStack.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("supervisor")
//connecting to FE
@CrossOrigin(origins = "*")
public class SupervisorController {
    private SupervisorService supervisorService;
    @Autowired
    public SupervisorController(SupervisorService supervisorService){
        this.supervisorService = supervisorService;
    }

    //getAllEmployee
    @GetMapping
    public List<Supervisor> getAllSupervisor(){
        return supervisorService.getAllSupervisor();
    }

    //getEmployeeById
    @GetMapping("view/{id}")
    public Supervisor getSupervisorById(@PathVariable Long id){
        return supervisorService.getSupervisorById(id);
    }

    //addEmployee
    @PostMapping
    public void addSupervisor(@RequestBody  Supervisor supervisor){
        supervisorService.addSupervisor(supervisor);
    }

    //editEmployee
    @PutMapping("edit/{id}")
    public Supervisor editSupervisor(@PathVariable Long id,@RequestBody Supervisor supervisor){
        return supervisorService.editSupervisor(id,supervisor);
    }

    //deleteEmployee
    @DeleteMapping("delete/{id}")
    public void deleteSupervisor(@PathVariable Long id){
        supervisorService.deleteSupervisor(id);
    }

    //addEmployeeToSupervisor
    @PostMapping("{supId}/add/{empId}")
    public Employee addEmployeeToSupervisor(@PathVariable Long supId, @PathVariable Long empId){
        return supervisorService.addEmployeeToSupervisor(supId, empId);
    }
}
