package com.jstl.servlet;

import com.jstl.domain.User;
import com.jstl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sign-up")
public class UserSignUpServlet extends HttpServlet {
    private UserService userService;
    public UserSignUpServlet(){
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/jsp/sign-up.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //if username does exist -> return message otherwise add user credentials then return message
        if (userService.doesUserExist(username)){
            //setting attribute as session message
            String message = "Username already exist\nTry considering other username";
            HttpSession session2 = req.getSession();
            session2.setAttribute("user",message);
            //redirecting to sign-up again
            //not changing the URL
            req.getRequestDispatcher("WEB-INF/jsp/sign-up.jsp").forward(req,resp);
        }else {
            //add credentials of user
            userService.addUser(new User(name,username,password));
            //return successful sign-up message
            String sign = "Sign-up successfully!";
            HttpSession session3 = req.getSession();
            session3.setAttribute("message",sign);
            //redirecting to sign-up again
            //not changing the URL
            req.getRequestDispatcher("WEB-INF/jsp/sign-up.jsp").forward(req,resp);

        }

        //the user needs to click the login button after signing-up
    }
}
