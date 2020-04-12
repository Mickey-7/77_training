package com.jstl.servlet;

import com.jstl.domain.User;
import com.jstl.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/users")
public class UserServlet extends HttpServlet {
    private UserService userService;
    public UserServlet(){
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //display all users
        List<User> users = userService.getAllUsers();
        //set users to attribute
        req.setAttribute("userList",users);
        //forward req to users.jsp
        req.getRequestDispatcher("WEB-INF/jsp/users.jsp").forward(req,resp);

    }
}
