package com.company;

import java.util.Scanner;

public class Diamond {

    //Exercise
    //Diamond.java
        //same as triangle but continue printing until it turns into a diamond

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("enter the limit");
        int n = scan.nextInt();
        for(int i=0; i<=n; i++){
            for(int j=i; j<=n; j++){
                System.out.print(" ");
            }
            for(int k=0; k<2*i-1; k++){
                System.out.print("*");
            }
            System.out.println(" ");
        }

        //output
        //enter the limit
        //7
        //
        //       *
        //      ***
        //     *****
        //    *******
        //   *********
        //  ***********
        // *************

        for(int i=n-1; i>0; i--){
            for(int j=n-i; j>=0; j--){
                System.out.print(" ");
            }
            for(int k=0; k<2*i-1; k++){
                System.out.print("*");
            }
            System.out.println(" ");
        }

        //output
        //  ***********
        //   *********
        //    *******
        //     *****
        //      ***
        //       *


    }
}
