package com.company.Exercise;

import java.util.HashSet;
import java.util.Set;

public class SetExercise {
    public static void main(String[] args) {

        //get all unique characters from the string
            //"Lorem ipsum dolot sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"
        //print and set the size

        //Set - an unordered collection of objects in which duplicate values cannot be stored. Basically, Set is implemented by HashSet.

        //storing the words in strings
        String strings = "Lorem ipsum dolot sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua";
        //create a blank set
        Set<Character> stringSet = new HashSet<>();
        //iterate on strings and stringSet automatically store unique characters from strings
        for (int i = 0; i < strings.length(); i++) {
            //add all the unique character to stringSet from strings
            stringSet.add(strings.charAt(i));
        }
        //print
        System.out.println(stringSet);
        //set the size
        System.out.println(stringSet.size());

    }
}
