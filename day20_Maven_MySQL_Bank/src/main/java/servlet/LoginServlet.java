package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;
    public LoginServlet() throws SQLException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet - Login : doGet ");
        HttpSession addUserSession = req.getSession();
        //removes the alert message session from sign-up : addUserSession
        addUserSession.removeAttribute("alert");
        req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet - Login : doPost ");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            if (userService.isUserValid(username,password)){
                HttpSession loginSession = req.getSession();
                loginSession.setAttribute("username",username);
                loginSession.setAttribute("password",password);
                resp.sendRedirect("menu");
            }else {
                String message = "Account does not exist";
                HttpSession doesNotExistSession = req.getSession();
                doesNotExistSession.setAttribute("alert",message);
                req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
