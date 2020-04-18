package com.company.Exercise;

import java.util.*;

public class MapExercise {
    public static void main(String[] args) {

        //create a map with words as the key and definition as value (at least 3), then print the map
        //get all keys as a list then print the list
        //get all values as a list then print the list
        //update all map values to "Error" then print map

        //Map<Key, Value> pair
        Map<String,String> dictionary = new HashMap<>();
        //use .put(key, value) for adding content
        dictionary.put("1st","una");
        dictionary.put("2nd","pangalawa");
        dictionary.put("3rd","pangatlo");
        //print the map
        System.out.println(dictionary);

        //setting all the keys of dictionary Map to  Set interface
        Set<String> keys = dictionary.keySet();
        System.out.println(keys);

        //setting all the values of dictionary Map to Collection interface
        Collection<String> values = dictionary.values();
        System.out.println(values);

        //update all map values to "Error" then print map
        //since Set is a list, we can use forLoop(enhanced) to retain keys
        //and replace all the values to Error
        for(String retain: keys){
            dictionary.replace(retain,"Error");
        }
        System.out.println(dictionary);




    }
}
