package com.example.day24_Postman_ToDoWithException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day24PostmanToDoWithExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day24PostmanToDoWithExceptionApplication.class, args);
	}

	//HTTP Methods: (REST Standard)
	//GET - retrieving resource/s (get student/s)
	//    - localhost:8080/students
	//POST - add resource/s (add student/s)
	//    - has request body (default: JSON)
	//    - localhost:8080/students
	//PUT - replace resource details (update student)
	//    - has request body (default: JSON)
	//    - localhost:8080/students/{id}
	//DELETE - delete resource (delete student)
	//    - localhost:8080/students/{id}
	//PATCH - update resource
	//    - has request body (default: JSON)
	//    - localhost:8080/students/{id}
}
