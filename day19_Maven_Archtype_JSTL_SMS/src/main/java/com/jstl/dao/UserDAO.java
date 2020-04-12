package com.jstl.dao;

import com.jstl.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    //create mock
    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User("name","user","pwd"));
    }

    //isUserValid - login
    public boolean isUserValid(String username, String password){
        return users.stream()
                .anyMatch(user -> user.getUsername().equals(username)
                    && user.getPassword().equals(password));
    }

    //doesUserExist - sign-up
    public boolean doesUserExist(String username){
        return users.stream()
                .anyMatch(user -> user.getUsername().equals(username));
    }

    //getAllUsers
    public List<User> getAllUsers( ){
        return users;
    }

    //addUser
    public void addUser(User user){
        users.add(user);
    }
}
