package dao;

import domain.User;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

//JDBC
public class UserDAO {
    private Connection connection = null;
    public UserDAO() throws SQLException {
        //establishing connection to bankDB
        connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/bankDB",
                "root",
                "PASSWORD"
        );
    }

    //check if user is valid- login
    public boolean isUserValid(String username, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from userBank where username=? and password=?"
        );
        //the preparedStatement and the input parameters are related
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,password);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if (resultSet.getString("username").equals(username) && resultSet.getString("password").equals(password)){
                return true;
            }else {
                return false;
            }
        }
        System.out.println("DAO - isUserValid");
        return Boolean.parseBoolean(null);
    }

    //check is user exist - sign-up
    public boolean doesUsernameExist(String username) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from userBank where username=?"
        );
        //the preparedStatement and the input parameters are related
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if (resultSet.getString("username").equals(username)){
                return true;
            }else {
                return false;
            }
        }
        System.out.println("DAO - doesUsernameExist");
        return Boolean.parseBoolean(null);
    }

    //add user
    public int addUser(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into userBank(username,password,balance," +
                        "transaction,transAmt,transDate,transTime) " +
                        "values (?,?,?,?,?,?,?)"
        );
        //the preparedStatement and the input parameters are related
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setDouble(3,user.getBalance());
        preparedStatement.setString(4,user.getTransaction());
        preparedStatement.setDouble(5,user.getTransAmt());
        preparedStatement.setDate(6, Date.valueOf(user.getTransDate()));
        preparedStatement.setTime(7, Time.valueOf(user.getTransTime()));
        int addedRowCount = preparedStatement.executeUpdate();
        System.out.println("DAO - addUser");
        return addedRowCount;
    }

    //view balance
    public Double viewBalance(String username) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from userBank where username=?  order by transTime desc, transDate desc limit 1  "
        );
        //the preparedStatement and the input parameters are related
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if (resultSet.getString("username").equals(username)){
                return resultSet.getDouble("balance");
            }
        }
        System.out.println("DAO - viewBalance");
        return null;
    }

    //record view balance
    public int recordViewBalance(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into userBank(username,password,balance,transaction," +
                        "transAmt,transDate,transTime) values(?,?,?,?,?,?,?)"
        );
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setDouble(3,user.getBalance());
        preparedStatement.setString(4,user.getTransaction());
        preparedStatement.setDouble(5,user.getTransAmt());
        preparedStatement.setDate(6, Date.valueOf(user.getTransDate()));
        preparedStatement.setTime(7, Time.valueOf(user.getTransTime()));
        int recordViewBalanceCount = preparedStatement.executeUpdate();
        System.out.println("DAO - recordViewBalance");
        return recordViewBalanceCount;

    }

    //deposit
    public int deposit(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into userBank(username,password,balance,transaction," +
                        "transAmt,transDate,transTime) values(?,?,?,?,?,?,?)"
        );
        //the preparedStatement and the input parameters are related
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setDouble(3,user.getBalance());
        preparedStatement.setString(4,user.getTransaction());
        preparedStatement.setDouble(5,user.getTransAmt());
        preparedStatement.setDate(6, Date.valueOf(LocalDate.now()));
        preparedStatement.setTime(7, Time.valueOf(LocalTime.now()));
        int depositCount = preparedStatement.executeUpdate();
        System.out.println("DAO - deposit");
        return depositCount;
    }

    //withdraw
    public int withdraw(User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "insert into userBank(username,password,balance," +
                        "transaction,transAmt,transDate,transTime)" +
                        " values(?,?,?,?,?,?,?)"
        );
        //the preparedStatement and the input parameters are related
        preparedStatement.setString(1,user.getUsername());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setDouble(3,user.getBalance());
        preparedStatement.setString(4,user.getTransaction());
        preparedStatement.setDouble(5,user.getTransAmt());
        preparedStatement.setDate(6, Date.valueOf(user.getTransDate()));
        preparedStatement.setTime(7, Time.valueOf(user.getTransTime()));
        int withdrawCount = preparedStatement.executeUpdate();
        System.out.println("DAO - withdraw");
        return withdrawCount;
    }

    //get latest transactions
    public List<User> getLatestTransactions( String username ) throws SQLException {
        //create blank list of user for the transactions
        List<User> users = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from userBank where username=?"
        );
        //the preparedStatement and the input parameters are related
        preparedStatement.setString(1,username);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            if (resultSet.getString("username").equals(username)) {
                users.add(new User(
                        resultSet.getString("username"),
                        resultSet.getDouble("balance"),
                        resultSet.getString("transaction"),
                        resultSet.getDouble("transAmt"),
                        resultSet.getDate("transDate").toLocalDate(),
                        resultSet.getTime("transTime").toLocalTime()
                ));
            }
        }
        System.out.println("DAO - getAllTransaction");
        return users;
    }

}
