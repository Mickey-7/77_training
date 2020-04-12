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

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {
    private UserService userService;
    public WithdrawServlet() throws SQLException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet - Withdraw : doGet");
        req.getRequestDispatcher("WEB-INF/jsp/withdraw.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet - Withdraw : doPost");
        //getting attributes from existing loginSession
        HttpSession loginSession = req.getSession();
        String username = (String) loginSession.getAttribute("username");
        String password = (String) loginSession.getAttribute("password");
        //get Parameter from withdraw.jsp with property name="withdraw"
        Double transAmt = Double.valueOf(req.getParameter("transAmt"));

        try {
            //creating blank user
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            //deducting the transAmt from previous balance
            Double newBal = userService.viewBalance(username)-transAmt;
            user.setBalance(newBal);
            user.setTransaction("Withdraw");
            user.setTransAmt(transAmt);
            user.setTransDate(LocalDate.now());
            user.setTransTime(LocalTime.now());
            userService.withdraw(user);
            //create message session to be displayed on withdraw.jsp
            String message = "Withdrawn Successfully!";
            HttpSession withdrawSession = req.getSession();
            withdrawSession.setAttribute("alert",message);
            req.getRequestDispatcher("WEB-INF/jsp/withdraw.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
