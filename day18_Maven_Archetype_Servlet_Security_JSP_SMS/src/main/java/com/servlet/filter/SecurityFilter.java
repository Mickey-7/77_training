package com.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(value = {"/addStudent"})
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("security filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //set HttpServletRequest to servletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //get existing session
        HttpSession session = httpServletRequest.getSession();
        //is username session is null _> redirect to login page
        if (session.getAttribute("username")==null){
            ((HttpServletResponse) servletResponse).sendRedirect("login");
        }else{
            System.out.println("security filter doFilter");
            //The doFilter method of the Filter is called by the container each time a request/response pair is passed through the chain due to a client request for a resource at the end of the chain.
            //The FilterChain passed in to this method allows the Filter to pass on the request and response to the next entity in the chain.
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("security filter destroy");
    }
}
