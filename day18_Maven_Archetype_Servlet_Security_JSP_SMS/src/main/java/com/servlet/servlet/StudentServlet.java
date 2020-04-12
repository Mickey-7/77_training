package com.servlet.servlet;

import com.servlet.domain.Student;
import com.servlet.service.StudentService;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    //create StudentService object
    private StudentService studentService;
    //invoking it to a constructor
    public StudentServlet(){
        this.studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //create list of Student and set all student on mock data from studentService
        List<Student> students = studentService.getAllStudents();
        //.setAttribute(String s, Object o) -> output : void
        req.setAttribute("student",students);
        System.out.println("student doGet");
        //.getRequestDispatcher(String s) -> output: RequestDispatcher
        //.forward(ServletRequest servletRequest, ServletResponse servletResponse) -> output : void
        req.getRequestDispatcher("WEB-INF/jsp/student.jsp").forward(req,resp);
   }
}
