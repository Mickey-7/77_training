package com.example.day25_SpringBoot_SMS;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day25SpringBootSmsPart2Application {

	public static void main(String[] args) {
		SpringApplication.run(Day25SpringBootSmsPart2Application.class, args);
	}

	//	Exercise:
	//	School Management API
	//* Student - id, firstName, lastName, grade
	//* Teacher - id, firstName, lastName
	//
	//	Features:
	//			- View/Add/Edit/Remove Student and Teacher
	//			- (Can't remove teacher with students)
	//			- Search Students By First Name And Last Name
	//			- Search Students by Teacher's Last Name
	//			- Search Teachers by Student Name (contains)


}
