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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/transaction")
public class TransactionServlet extends HttpServlet {
    private UserService userService;
    public TransactionServlet() throws SQLException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet - Transaction : doGet");
        //get attribute of existing loginSession
        HttpSession loginSession = req.getSession();
        String username = (String) loginSession.getAttribute("username");

        try {
            //create list of users the set all its transaction
            List<User> users = userService.getAllTransaction(username);
            //storing list of transaction to session the displaying it on transaction.jsp
            HttpSession transactionSession = req.getSession();
            transactionSession.setAttribute("users",users);
            req.getRequestDispatcher("WEB-INF/jsp/transaction.jsp").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
