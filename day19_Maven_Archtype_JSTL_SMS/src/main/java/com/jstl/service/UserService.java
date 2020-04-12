package com.jstl.service;

import com.jstl.dao.UserDAO;
import com.jstl.domain.User;

import java.util.List;

public class UserService {
    //create UserDAO object
    private UserDAO userDAO;
    //invoke in a constructor the object above
    public UserService(){
        this.userDAO = new UserDAO();
    }

    public boolean isUserValid(String username, String password){
        return userDAO.isUserValid(username,password);
    }

    public boolean doesUserExist(String username){
        return userDAO.doesUserExist(username);
    }

    public List<User> getAllUsers( ){
        return userDAO.getAllUsers();
    }

    public void addUser(User user){
        userDAO.addUser(user);
    }

}
