package servlet;

import domain.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

@WebServlet("/sign-up")
public class SignUpServlet extends HttpServlet {
    private UserService userService;
    public SignUpServlet() throws SQLException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet - Sign-up : doGet");
        HttpSession doesNotExistSession = req.getSession();
        //removes the alert message session from login
        doesNotExistSession.removeAttribute("alert");
        req.getRequestDispatcher("WEB-INF/jsp/sign-up.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet - Sign-up : doPost");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Double balance = Double.parseDouble(req.getParameter("balance"));

        try {
            if (userService.doesUserExist(username)){
                String message = "Username Already Exist\n Try considering other Username";
                HttpSession usernameExistSession = req.getSession();
                usernameExistSession.setAttribute("alert",message);
                req.getRequestDispatcher("WEB-INF/jsp/sign-up.jsp").forward(req,resp);
            }else {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setBalance(balance);
                user.setTransaction("Initial Deposit");
                user.setTransAmt(balance);
                user.setTransDate(LocalDate.now());
                user.setTransTime(LocalTime.now());
                userService.addUser(user);
                String message = "Successfully Signed-up!";
                HttpSession addUserSession = req.getSession();
                addUserSession.setAttribute("alert",message);
                req.getRequestDispatcher("WEB-INF/jsp/sign-up.jsp").forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
