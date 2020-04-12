package com.servlet.servlet;

import com.servlet.domain.Student;
import com.servlet.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addStudent")
public class AddStudentServlet extends HttpServlet {
    //create StudentService object
    private StudentService studentService;
    //invoking in to constructor
    public AddStudentServlet(){
        this.studentService = new StudentService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //rendering the addStudent.jsp
        //.getRequestDispatcher(String s) -> output: RequestDispatcher
        //.forward(ServletRequest servletRequest, ServletResponse servletResponse) -> output : void
        System.out.println("addStudent doGet");
        req.getRequestDispatcher("WEB-INF/jsp/addStudent.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get details from input fields of addStudent.jsp
        //.getParameter(String s) -> output : void
        //connected to name="" property of input fields on addStudent.jsp
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String grade = req.getParameter("grade");

        //create student object then add it to the list via studentService
        //.parseLong(String s) -> output : long
        Student student = new Student(Long.parseLong(id),name,Double.parseDouble(grade));
        studentService.addStudent(student);

        System.out.println("addStudent doPost");
        //redirect to student.jsp after adding
        resp.sendRedirect("student");

    }
}
