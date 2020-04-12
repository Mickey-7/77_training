package service;

import dao.UserDAO;
import domain.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO;
    public UserService() throws SQLException {
        this.userDAO = new UserDAO();
    }

    public boolean isUserValid(String username, String password) throws SQLException {
        System.out.println("Service - isUserValid");
        return userDAO.isUserValid(username,password);
    }

    public boolean doesUserExist(String username) throws SQLException {
        System.out.println("Service - doesUsernameExist");
        return userDAO.doesUsernameExist(username);
    }

    public int addUser(User user) throws SQLException {
        return userDAO.addUser(user);
    }

    public Double viewBalance(String username) throws SQLException {
        System.out.println("Service - viewBalance");
        return userDAO.viewBalance(username);
    }

    public int recordViewBal(User user) throws SQLException {
        System.out.println("Service - recordViewBalance");
        return userDAO.recordViewBalance(user);
    }

    public int deposit(User user) throws SQLException {
        System.out.println("Service - deposit");
        return userDAO.deposit(user);
    }

    public int withdraw(User user) throws SQLException {
        System.out.println("Service - withdraw");
        return userDAO.withdraw(user);
    }

    public List<User> getAllTransaction(String username) throws SQLException {
        System.out.println("Service - getAllTransaction");
        return userDAO.getLatestTransactions(username);
    }

}
