package com.company.Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //Java Generic methods & classes enable programmers to specify, with a single method declaration,
        //a set of related methods, or with a single declaration, a set of related types, respectively

        //Generics:
            //-(Main) lastListItem (generic method) : accepts a list of type T and return the last list item
            //-Envelope<T> (generic class) : generic constructor with object of type T as input, getters & setters
            //-(Main) create Envelope object and print the generic object inside

        System.out.println("what type do you want T to be:\n" +
                "1) String\n" +
                "2) Integer");
        int T_type = scanner.nextInt();

        switch (T_type){
            case 1:
                System.out.println("you choose T to be String type");
                System.out.println("how many items you want to be on the list: ");
                int stringList = scanner.nextInt();
                //create blank String arrayList
                List<String> strings = new ArrayList<>();
                for (int i = 1; i <= stringList; i++) {
                    System.out.println("enter "+i+"st item : ");
                    String string = scanner.next();
                    strings.add(string);
                }
                //printing list items
                System.out.println(strings);
                //calling method to return last list item
                System.out.println(lastListItem(strings));
                break;
            case 2:
                System.out.println("you choose T to be Integer type");
                System.out.println("how many items you want to be on the list: ");
                int integerList = scanner.nextInt();
                //create blank String arrayList
                List<Integer> integers  = new ArrayList<>();
                for (int i = 1; i <= integerList; i++) {
                    System.out.println("enter "+i+"st item : ");
                    Integer integerItem = scanner.nextInt();
                    integers.add(integerItem);
                }
                //printing list items
                System.out.println(integers);
                //calling method to return last list item
                System.out.println(lastListItem(integers));
                break;
            default:
                System.out.println("invalid T type");
                break;
        }


        //create Envelope object and print the generic object inside
        Envelope<Object> envelopeObject = new Envelope<>("printing this generic object inside Envelope");

//        System.out.println(envelopeObject); //output -> Envelope<Object> -> com.company.Generics.Envelope@2e0fa5d3

        //so we need to used .getObject() method -> output : Object
        System.out.println(envelopeObject.getObject());

    }

    //convert String to T type - accepts a list of type T
    private static <T> T lastListItem(List<T> item) {
        //return last item
        return item.get(item.size()-1);
    }

    //notice that were using one single method for both case
}
