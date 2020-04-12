package com.servlet.dao;

import com.servlet.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    //create mock data of user
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("user","pwd"));
    }
    //end of mock creation

    //method for checking username & password
    public boolean isUserValid(String username,String password){
        return users.stream()
                //.anyMatch(Predicate<? super User>predicate) -> output boolean
                .anyMatch(user -> user.getUsername().equals(username)
                        && user.getPassword().equals(password));
    }
}
