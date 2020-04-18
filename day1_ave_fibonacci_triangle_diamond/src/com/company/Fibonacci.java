package com.company;

import java.util.Scanner;

public class Fibonacci {

    //Exercise
    //Fibonacci.java
        //0, 1, 1, 2, 3, 5, 8, 13,....n
        //accept n input
        //n=1, out=0 and n=7, out=8

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter nth term: ");
        int nth = scanner.nextInt();

        int n1 = 0; // first term
        int n2 = 1; // second term
        int n3 = 0; // sum storage of the previous terms
        for (int i = 0; i < nth; i++) {
            n3=n1; // setting zero sum for first iteration
            //at i=0, n3=0
            //at i=1, n3=1
            //at i=2, n3=1
            //at i=3, n3=2
            //at i=4, n3=3
            n1=n2; // setting the 0(1st term) to 1(2nd term)
            //at i=0, n1=1
            //at i=1, n1=1
            //at i=2, n1=2
            //at i=3, n1=3
            //at i=4, n1=5
            n2=n2+n3; // setting the 1(2nd term) to 2(3rd term)
            //at i=0, n2=1
            //at i=1, n2=2
            //at i=2, n2=3
            //at i=3, n2=5
            //at i=4, n2=8
        }
        System.out.println(n3);
    }

}
