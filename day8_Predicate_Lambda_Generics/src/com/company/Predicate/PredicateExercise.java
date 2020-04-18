package com.company.Predicate;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;


public class PredicateExercise {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //Predicate: checks if input list is empty or null
        //Predicate: checks if input string has at least one vowel (a,e,i,o,u)
        //Consumer: appends an input string to an existing StringBuilder
        //Function: return set of 2 distinct string from 2 input list of string
            //ex:   input 1: ["a","b","c"],
            //      input 2: ["a","b","f"],
            //return: Set("a","b","c","f") - as set only return unique values
        //Function: return last element from input list of String

        //Predicate is a function interface that can be used as assignment target for lambda expression
        //Predicate interface represents an operation that takes a single input and returns a boolean value

        //Consumer<T> is an in-built functional interface which can be used on all contexts where an object needs to be
        //consumed,i.e. taken as input, and some operation is to be performed on the object without returning any result

        //Function is a piece of code that is called by its name, it can be passed data to operate on and can optionally
        //return data. All data that is passed to a function is explicitly passed. Explicit means done by the programmer
        //Implicit means done by JVM or the tool, no the programmer

        System.out.println("what would you like to do?\n" +
                "1) emptyOrNullListPredicateChecker\n" +
                "2) vowelStringPredicateChecker\n" +
                "3) stringBuilderConsumerAppender\n" +
                "4) distinctListFunctionCombiner\n" +
                "5) lastElementListFunctionReturner");
        int toDo = scanner.nextInt();

        switch (toDo){
            case 1:
                System.out.println("emptyOrNullListPredicateChecker");
                //create arrayList of String input
                List<String> inputs = Arrays.asList(null,"","there is something here");
                //printing the inputs
                System.out.println("inputs : "+inputs);
                //using Predicate<T> java.util.function -> x is the T type which is a String
                //i don't know the order is important but we need to write null first before isEmpty() method
                //else Exception in thread "main" java.lang.NullPointerException will occur
                Predicate<String> checker = x -> (x==null||x.isEmpty());
                //iterating on the arrayList to test for each item
                for (String item : inputs){
                    System.out.println(checker.test(item));
                }
                break;
            case 2:
                System.out.println("vowelStringPredicateChecker");
                vowelStringPredicateChecker();
                break;
            case 3:
                System.out.println("stringBuilderConsumerAppender");
                stringBuilderConsumerAppender();
                break;
            case 4:
                System.out.println("distinctListFunctionCombiner");
                distinctListFunctionCombiner();
                break;
            case 5:
                System.out.println("lastElementListFunctionReturner");
                lastElementListFunctionReturner();
                break;
            default:
                System.out.println("invalid shit");
                break;
        }
    }

    private static void lastElementListFunctionReturner() {
        System.out.println("how many items you want on the list: ");
        int listCount = scanner.nextInt();
        //create blank arrayList of String
        List<String> inputs = new ArrayList<>();
        for (int i = 1; i <= listCount; i++) {
            System.out.println("enter item "+i+" : ");
            String input = scanner.next();
            inputs.add(input);
        }
        //Function<T,R> (java.util.function)
        //String (java.lang)
        //.valueOf(char c) -> output : String
        //.charAt(int index) -> output : char
        //.length() -> output : int
        //x is the T which is a String
        Function<String, String> function = x -> String.valueOf(x.charAt(x.length()-1));
        //iterating at the arrayList
        for (String item : inputs){
            //.apply(String t) -> output : String
            System.out.println(function.apply(item));
        }
    }

    private static void distinctListFunctionCombiner() {
        //first list
        System.out.println("how many items you want on the 1st list: ");
        int firstList = scanner.nextInt();
        //create blank arrayList of String
        List<String> firsts = new ArrayList<>();
        for (int i = 1; i <= firstList; i++) {
            System.out.println("enter item "+i+" : ");
            String first = scanner.next();
            firsts.add(first);
        }
        //second list
        System.out.println("how many items you want on the 2nd list: ");
        int secondList = scanner.nextInt();
        //create blank arrayList of String
        List<String> seconds = new ArrayList<>();
        for (int i = 1; i <= secondList; i++) {
            System.out.println("enter item "+i+" : ");
            String second = scanner.next();
            seconds.add(second);
        }
        //BiFunction<T,U,R> (java.util.function)
        BiFunction<List<String>, List<String>, HashSet<String>> distinction =
                //x for T and y for U and distinctionList for R
                (x,y) -> {
                    //create blank Set distinctionList - contains no duplicate elements
                    //Set - general interface to a set-like collection
                    //HashSet  - is a specific implementation os Set interface
                    //(which uses hash codes, hence the name)
                    HashSet<String> distinctionList = new HashSet<>();
                    //.addAll(String<? extends String>c) -> output : boolean
                    distinctionList.addAll(x);
                    distinctionList.addAll(y);
                    return distinctionList;
                };
        //.apply(String t, String u) -> output : HashSet<String> from BiFunction above
        //set t->x->firsts & u->y->seconds
        System.out.println(distinction.apply(firsts,seconds));
    }

    private static void stringBuilderConsumerAppender() {
        //create StringBuilder
        StringBuilder stringBuilder = new StringBuilder("this is an existing StringBuilder");
        //prints existing StringBuilder
        System.out.println(stringBuilder);
        //Consumer<T> java.util.function -> x is the T type to be appended by the appender from Consumer
        Consumer<String> appender = x ->  System.out.println(stringBuilder.append(x));
        //.accept(String t) -> output : void
         appender.accept(" : this is the Consumer appending");

    }

    private static void vowelStringPredicateChecker() {
        System.out.println("how many inputs on the list you want to have? ");
        int count = scanner.nextInt();
        //create blank arrayList of String
        List<String> strings = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            System.out.println("enter string input "+i+" : ");
            String input = scanner.next();
            strings.add(input);
        }
        //displaying inputs
        System.out.println("inputs : "+strings);
        //using Predicate<T> x is the T type which is String
        //.toLowerCase() method to handle caps lock sensitivity -> output : String
        //.contains(CharSequence csq) -> output : boolean
        Predicate<String> checker = x ->
                        x.toLowerCase().contains("a")||
                        x.toLowerCase().contains("e")||
                        x.toLowerCase().contains("i")||
                        x.toLowerCase().contains("o")||
                        x.toLowerCase().contains("u");
        //iterating on the strings which is inputted bu the user
        for (String input : strings){
            System.out.println(checker.test(input));
        }
    }
}
