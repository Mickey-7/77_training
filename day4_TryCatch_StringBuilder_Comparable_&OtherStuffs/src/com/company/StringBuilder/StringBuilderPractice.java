package com.company.StringBuilder;

public class StringBuilderPractice {
    public static void main(String[] args) {

        //create a comma-separated string of numbers 1-100

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            System.out.println(stringBuilder.append(i).append(","));
        }

    }

}
