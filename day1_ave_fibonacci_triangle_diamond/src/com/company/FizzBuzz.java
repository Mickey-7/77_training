package com.company;

public class FizzBuzz {

    //Exercise
    //FizzBuzz.java
        //prints 1-100
        //for multiples of 3 print Fizz
        //for multiples of 5 print Buzz
        //for multiples of 15 print FizzBuzz

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(
                    i%15==0? "FizzBuzz":i%5==0?
                            "Buzz":i%3==0? "Fizz": String.valueOf(i)
            );

        }
    }
}
