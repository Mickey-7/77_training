package com.company;

import java.util.Scanner;

public class Triangle {

    //Exercise
    //Triangle.java
        //accept n as input
        //print a triangle if n=2
        //     *
        //    ***
        //print triangle if n=3
        //      *
        //     ***
        //    *****


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the limit");
        int n = scanner.nextInt();

//        for (int i = 0; i < n; i++) {
//            System.out.print("*");
//            //output
//            //enter the limit
//            //3
//            //***
//        }
//
//        for (int i = 0; i <= n; i++) {
//            System.out.print("*");
//            //output
//            //enter the limit
//            //3
//            //****
//        }

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print("*");
//            }
//            for (int k = 0; k < n; k++) {
//                System.out.print("*");
//            }
//            System.out.println(" ");
//            //output
//            //enter the limit
//            //3
//            //******
//            //******
//            //******
//        }

//        for (int i = 0; i < n; i++) {
//            //making j=i
//            for (int j = i; j < n; j++) {
//                //making print white space
//                System.out.print(" ");
//            }
//            for (int k = 0; k < n; k++) {
//                System.out.print("*");
//            }
//            System.out.println(" ");
//            //out[ut
//            //enter the limit
//            //3
//            //   ***
//            //  ***
//            // ***
//        }

        for (int i = 0; i < n; i++) {
            //making j=i
            for (int j = i; j < n; j++) {
                //making print white space
                System.out.print(" ");
            }
            for (int k = 0; k < 2*i-1; k++) {
                System.out.print("*");
            }
            System.out.println(" ");
            //out[ut
            //enter the limit
            //3
            //
            //  *
            // ***
        }




    }
}
