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

@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {
    private UserService userService;
    public BalanceServlet() throws SQLException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet - Balance : doGet");
        //getting attributes from existing loginSession
        HttpSession loginSession = req.getSession();
        String username = (String) loginSession.getAttribute("username");
        String password = (String) loginSession.getAttribute("password");

        try {
            //getting balance from database via userService
            Double bal = userService.viewBalance(username);
            //creating blank user for database record
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setBalance(bal);
            user.setTransaction("Balance");
            user.setTransAmt((double) 0);
            user.setTransDate(LocalDate.now());
            user.setTransTime(LocalTime.now());
            userService.recordViewBal(user);
            //creating session for the balance to be displayed
            HttpSession balSession = req.getSession();
            balSession.setAttribute("balance",bal);
            req.getRequestDispatcher("WEB-INF/jsp/balance.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }




    }
}
