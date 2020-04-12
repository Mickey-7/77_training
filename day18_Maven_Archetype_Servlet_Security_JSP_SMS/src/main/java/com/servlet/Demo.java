package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sample")
public class Demo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //.getRequestDispatcher(String s) -> output: RequestDispatcher
        //.forward(ServletRequest servletRequest, ServletResponse servletResponse) -> output : void
        req.getRequestDispatcher("WEB-INF/sample.jsp").forward(req,resp);

    }
}
