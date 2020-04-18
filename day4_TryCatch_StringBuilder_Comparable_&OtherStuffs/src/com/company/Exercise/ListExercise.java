package com.company.Exercise;


import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

//be careful on naming your class based on the topic as importing might go wrong
//if class name is same as java utils needed to be imported
public class ListExercise {
    public static void main(String[] args) {

        //create a list of string for each word in:
            //"Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua"
        //print the list
        //convert items to uppercase, then print the list
        //sort the list by number of characters, print each word with the number of characters ({word}-4)
        //delete the items with less than 5 characters from the sorted list, then print the list

        //storing the words in strings
        String strings = "Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua";
        //creating blank List with String data type
        List<String> stringList = new ArrayList<>();
//        //print the list
//        System.out.println(stringList); //output []

        //use Collections when dealing with arrayList
        //use addAll(x,y) method, x->blank List, y->strings to be split
        Collections.addAll(stringList,strings.split(" "));
        //print the list
        System.out.println(stringList);


        //convert to uppercase
        for (int i = 0; i < stringList.size(); i++) {
//            //no effect
//            stringList.get(i).toUpperCase(); //output [Lorem, ipsum, dolor, sit, amet, consectetur, adipiscing, elit, sed, do, eiusmod, tempor, incididunt, ut, labore, et, dolore, magna, aliqua]

            //we must use .set(int i, String e) instead of .get(int i)
            //and use .get(i) for the String parameter
            stringList.set(i,stringList.get(i).toUpperCase());
        }
        //print the list
        System.out.println(stringList);


        //sort the list by number of characters,
        Collections.sort(stringList,((s, t1) -> {
            return s.length()-t1.length();
        }));
        //print each word with the number of characters ({word}-4)
        for(String word: stringList){
            //the word variable represent every item on the list
            System.out.print(word+" - "+word.length());
        }
        System.out.println();


        //delete the items with less than 5 characters from the sorted list, then print the list
        //make a list for the words to be removed - less than 5 characters
        List<String> toBeRemove = new ArrayList<>();
        for(String word : stringList){
            if(word.length()<5){
                toBeRemove.add(word);
            }
        }
        //list have a method of removeAll
        stringList.removeAll(toBeRemove);
        System.out.println(stringList);





    }
}
