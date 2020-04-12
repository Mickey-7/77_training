package com.servlet.servlet;

import com.servlet.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    //create UserService object
    private UserService userService;
    //invoking object above to constructor
    public LoginServlet(){
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("login doGet");
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //getting the parameter from input fields of login.jsp
        //.getParameter(String s) -> output : String
        //connected to name="" property of input fields on login.jsp
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //logic id user is valid -> add it to session the redirect to addStudent otherwise go back to login page
        if (userService.isUserValid(username,password)){
            //create Session and setting the username to that session via setAttribute
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            System.out.println(session);
            System.out.println("login doPost");
            //redirecting to addStudent page
            //we use resp for the URL to change
            resp.sendRedirect("addStudent");
        }else {
            System.out.println("login doPost");
            //redirecting to login page
            //we use req for the URL not to change but will still display the page
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req,resp);
        }
    }
}
