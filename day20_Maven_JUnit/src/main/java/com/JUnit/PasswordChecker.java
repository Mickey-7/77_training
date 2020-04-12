package com.JUnit;

public class PasswordChecker {

    //create PasswordChecker (class + test class)
        //Boolean isValidPassword(String password)
            //must be greater than 6 characters
            //must be alphanumeric only
            //at least one uppercase char
            //at least one lowercase char
            //at least one number

    public Boolean isValidPassword(String password){
        return password.matches(
                //at least one lowercase char - (?=.*[a-z])
                //at least one uppercase char - (?=.*[A-Z])
                //at least one number - (?=.*\d)
                //must be alphanumeric only - [a-zA-Z\d]
                //must be greater than 6 characters - {7,}
                "(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{7,}"
        );
    }
}
