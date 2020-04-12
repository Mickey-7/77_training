package com.servlet.service;

import com.servlet.dao.UserDAO;

public class UserService {
    //create UserDAO object
    private UserDAO userDAO;
    //invoking object above on constructor
    public UserService(){
        this.userDAO = new UserDAO();
    }

    public boolean isUserValid(String username, String password){
        return userDAO.isUserValid(username, password);
    }
}
