package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //LECTURES

        //print 0-99 using traditional for-loop
        //using traditional for-loop
        for (int i = 0; i < 100; i++) {
            //notice we used print instead of println
            System.out.print(i+" ");
        }
        System.out.println(" ");

        //print 1-7 using enhanced for-loop
        //creating array of integers from 1-7
        int[] intArray = {1,2,3,4,5,6,7};
        //System.out.println(intArray); will output [I@34c45dca
        //Above wont work as we need to store it on variable first
        //arrays&for-loops always come together?
        //using enhanced for-loop
        //for(data_type variable: array_name)
        for(int i : intArray){
            System.out.print(i+" ");
        }
        System.out.println(" ");

        //print squares of 1 to 100 then get the sum
        //1^2, 2^2, 3^2, 4^2, 5^2, 6^2, 7^2, ........, 100^2
        //initiate zero sum at first
        int sum=0;
        //creating arrays of integers from 1 to 100
        int[] newIntArray = new int[100];
        for (int i = 0; i < 100; i++) {
            newIntArray[i]=(i+1)*(i+1);
            //at i=0, 1*1=1
            //at i=1, 2*2=4
            //at i=2, 3*3=9
            System.out.print(newIntArray[i]+" ");
            sum += newIntArray[i];
        }
        System.out.println(" ");
        System.out.println("sum : "+sum);

        //calling ifElse method below
        ifElse();

        //calling switchCase method below
        switchCase();

        //calling whileLoop method below
        whileLoop();
    }

    private static void whileLoop() {
        System.out.println("print 1-100 using while loop");
        //declare variable i to 0
        int i=0;
        while (i<100){
            //increment by 1
            System.out.print(++i+ " ");
        }
        System.out.println();

        System.out.println("Even numbers: ");
        int j=0;
        while (j<100){
            //increment by 2
            System.out.print((j+=2)+" ");
        }
        System.out.println();

        System.out.println("Multiples of 3: ");
        int k=0;
        while (k<100){
            //increment by 3
            System.out.print((k+=3)+" ");
        }
    }

    private static void switchCase() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a letter: ");
        //getting the input and storing it to letter variable
        String letter = scanner.nextLine();
        //using switch and capturing upper/lower case issues
        switch (letter.toLowerCase()){
            case "a":
                System.out.println("A");
                break;
            case "b":
                System.out.println("B");
                break;
            case "c":
                System.out.println("C");
                break;
            case "d":
                System.out.println("D");
                break;
        }
    }

    //method for checking if entered number if greater than or equal to 75
    //if entered number is odd or even
    //if entered number if divisible by 5 and 3
    public static void ifElse(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        //getting the input and storing it to num variable
        int num = scanner.nextInt();
        System.out.println(num>=75? "pass":"fail");
        System.out.println(num%2==0? "even":"odd");
        System.out.println(num%15==0? "divisible by 5 & 3":num%5==0? "divisible by 5":num%3==0? "divisible by 3":"not divisible by 3 and 5");
    }
}
