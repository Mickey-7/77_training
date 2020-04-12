package domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class User {
    private String username;
    private String password;
    private Double balance;
    private String transaction;
    private Double transAmt;
    private LocalDate transDate;
    private LocalTime transTime;

    public User(){}

    //another for constructor for get all transaction
    public User(String username, Double balance, String transaction, Double transAmt, LocalDate transDate, LocalTime transTime) {
        this.username = username;
        this.balance = balance;
        this.transaction = transaction;
        this.transAmt = transAmt;
        this.transDate = transDate;
        this.transTime = transTime;
    }

    public User(String username, String password, Double balance, String transaction, Double transAmt, LocalDate transDate, LocalTime transTime) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.transaction = transaction;
        this.transAmt = transAmt;
        this.transDate = transDate;
        this.transTime = transTime;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public Double getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(Double transAmt) {
        this.transAmt = transAmt;
    }

    public LocalDate getTransDate() {
        return transDate;
    }

    public void setTransDate(LocalDate transDate) {
        this.transDate = transDate;
    }

    public LocalTime getTransTime() {
        return transTime;
    }

    public void setTransTime(LocalTime transTime) {
        this.transTime = transTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", transaction='" + transaction + '\'' +
                ", transAmt=" + transAmt +
                ", transDate=" + transDate +
                ", transTime=" + transTime +
                '}';
    }
}
