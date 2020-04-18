package com.company.Exercise;

import java.util.Scanner;

public class TryCatch {
    public static void main(String[] args) {

        //use exception to verify if a string is a valid double or not

        Scanner scanner = new Scanner(System.in);
        System.out.println("enter shit: ");
        String shit = scanner.next();

//        //parseDouble(String s) -> double
//        Double.parseDouble(shit);
//        System.out.println(shit+" is a valid double");

        //output
        //enter shit:
        //w
        //Exception in thread "main" java.lang.NumberFormatException: For input string: "w"
        //	at java.base/jdk.internal.math.FloatingDecimal.readJavaFormatString(FloatingDecimal.java:2054)
        //	at java.base/jdk.internal.math.FloatingDecimal.parseDouble(FloatingDecimal.java:110)
        //	at java.base/java.lang.Double.parseDouble(Double.java:543)
        //	at com.company.Exercise.TryCatch.main(TryCatch.java:15)

        //error above shows we need to use try catch on line 15

        try {
            Double.parseDouble(shit);
            System.out.println(shit+" is a valid double");
        }catch (NumberFormatException e){
            System.out.println(shit+" is not a valid double");
        }



    }
}
