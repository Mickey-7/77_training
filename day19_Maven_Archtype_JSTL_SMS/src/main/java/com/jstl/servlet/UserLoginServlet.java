package com.jstl.servlet;

import com.jstl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginServlet extends HttpServlet {
    private UserService userService;
    public UserLoginServlet(){
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //display login.jsp
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get input field value from login.jsp via name="" property and passed as parameter
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //if valid user -> login, otherwise display message
        if (userService.isUserValid(username,password)){
            //add user to session
            HttpSession session = req.getSession();
            //setting attributes of the user session
            session.setAttribute("name",name);
            session.setAttribute("username",username);
            session.setAttribute("password",password);
            //redirect to list of users
            //will render the page users and change the URL
            resp.sendRedirect("users");
        }else {
            //create message
            String message = "Account does not exist";
            //create session
            HttpSession session1 = req.getSession();
            //set attribute of session to message
            session1.setAttribute("loginMessage",message);
            //still redirect to login page
            //req will not change the URL
            req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req,resp);
        }

        //if still no account exist
        //the user needs to click sign-up button

    }
}
