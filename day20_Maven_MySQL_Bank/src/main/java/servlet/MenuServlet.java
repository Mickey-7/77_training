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

@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    private UserService userService;
    public MenuServlet() throws SQLException {
        this.userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet - Menu : doGet");
        //removing message session
        HttpSession session = req.getSession();
        session.removeAttribute("alert");
        session.removeAttribute("alert");
        req.getRequestDispatcher("WEB-INF/jsp/menu.jsp").forward(req,resp);
    }
}
