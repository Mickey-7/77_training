package com.example.day22_ThymeLeaf_Part2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day22ThymeLeafPart2Application {

	public static void main(String[] args) {
		SpringApplication.run(Day22ThymeLeafPart2Application.class, args);
	}

	//Employee
	//    - Create from Spring Initializr
	//    - View, Add, Delete Employee
	//    - Employee: id, name, salary
	//    - MVC
	//    - EmployeeDAO: (can be DB-connected)
	//        - static list of employees
	//        - no DB
	//    - Controller:
	//        - page display doesn't matter
	//        - (sout) print updated list of employees each method call
}
