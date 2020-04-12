package com.jstl.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(value = {"/users"})
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //cast ServletRequest to HttpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //getting the session used for logging in
        HttpSession session = httpServletRequest.getSession();
        //if no user is login -> redirect to login otherwise filter chain
        if (session.getAttribute("username")==null){
            //cast ServletResponse to HttpServletResponse
            ((HttpServletResponse)servletResponse).sendRedirect("login");
        }else {
            //The doFilter method of the Filter is called by the container each time a request/response pair is passed through the chain due to a client request for a resource at the end of the chain.
            //The FilterChain passed in to this method allows the Filter to pass on the request and response to the next entity in the chain.
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
