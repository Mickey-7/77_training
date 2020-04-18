package com.company;

import java.util.Scanner;

public class Average {

    //Exercise
    //Average.java
        //-accept 2 numbers as input
        //-print the sum and average of even numbers between the 2 numbers

    public static void main(String[] args) {
        int sum=0;
        double average=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.println("Enter second number: ");
        int num2 = scanner.nextInt();
        //for-loop to iterate between 2 entered numbers
        for (int i = num1; i <= num2; i++) {
            //check if i's are even numbers
            if(i%2==0){
//                //check whats inside of i
//                System.out.println(i);
                //get sum of i's
                sum+=i;
                //get average of i's
                average=sum/i;

            }
        }
        //print sum & average of i's outside the for-loop
        System.out.println(sum);
        System.out.println(average);
    }

}
