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

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {
    private UserService userService;
    public DepositServlet() throws SQLException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet - Deposit : doGet");
        req.getRequestDispatcher("WEB-INF/jsp/deposit.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet - Deposit : doPost");
        //getting attributes from existing loginSession
        HttpSession loginSession = req.getSession();
        String username = (String) loginSession.getAttribute("username");
        String password = (String) loginSession.getAttribute("password");
        //get Parameter from deposit.jsp with property of name="deposit"
        Double transAmt = Double.parseDouble(req.getParameter("transAmt"));

        try {
            //creating blank user for database record
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            //adding transAmt to existing balance
            Double newBalance = userService.viewBalance(username) + transAmt;
            user.setBalance(newBalance);
            user.setTransaction("Deposit");
            user.setTransAmt(transAmt);
            user.setTransDate(LocalDate.now());
            user.setTransTime(LocalTime.now());
            userService.deposit(user);
            //create message session for notification on deposit.jsp
            String message = "Deposited Successfully!";
            HttpSession depositSession = req.getSession();
            depositSession.setAttribute("alert",message);
            req.getRequestDispatcher("WEB-INF/jsp/deposit.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
