package com.company.TryCatch;

import java.util.Scanner;

public class TryCatchPractice {
    public static void main(String[] args) {

        //Create a method to divide two numbers
        //Handle ArithmeticException (division by 0), return 0

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter first number: ");
        int num1 = scanner.nextInt();
        System.out.println("enter second number: ");
        int num2 = scanner.nextInt();

//        System.out.println(quotient(num1,num2));

        //output on the console
        //enter first number:
        //5
        //enter second number:
        //0
        //Exception in thread "main" java.lang.ArithmeticException: / by zero
        //	at com.company.TryCatch.TryCatchPractice.quotient(TryCatchPractice.java:23)
        //	at com.company.TryCatch.TryCatchPractice.main(TryCatchPractice.java:17)

        //Error above occurred so we need to use try catch on line:17
        //creating a new print with try catch

        try{
            System.out.println(quotient(num1,num2));
        }catch (ArithmeticException e){
            System.out.println("error catcher");
        }



    }

    //create a method to get quotient
    public static int quotient(int a, int b){
        return a/b;
    }
}
