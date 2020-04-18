package com.company.Lambda;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        //Java Lambda - function which can be created without belonging to any class

        //Lambda:
            //sortListByLength:
                //accepts List<String> and returns the sorted List<String> (use lambda comparator)
            //removeEvenNumbers:
                //accepts List<Integer> and returns a List<Integer> with the even numbers removed (use list.removedIf)
            //filterGenericList:
                //accepts List<T> and Predicate<T> and returns List<T> with items that satisfy the predicate
            //filterGenericMap:
                //accepts Map<K,V> and Predicate<K,V> and returns Map<K,V> with entries that satisfy the predicate
            //updateList:
                //accepts List<Double> and Function<Double, Double> and returns List<Double> containing items that executed the function


        System.out.println("what would you like to do?\n" +
                "1) sortListByLength\n" +
                "2) removeEvenNumbers\n" +
                "3) filterGenericList\n" +
                "4) filterGenericMap\n" +
                "5) updateList");
        int toDo = scanner.nextInt();


        switch (toDo){
            case 1:
                System.out.println("case1");
                System.out.println("how many string you want: ");
                int stringCount = scanner.nextInt();
                //need to create blank list of String
                List<String> strings = new ArrayList<>();
                for (int i = 1; i <= stringCount; i++) {
                    System.out.println("enter string "+i+" : ");
                    String string = scanner.next();
                    strings.add(string);
                }
                //displaying unsorted strings
                System.out.println(strings);
                //calling the method below to sort the strings
                System.out.println(sortListByLength(strings));
                break;
            case 2:
                System.out.println("case2");
                System.out.println("how many integer you want: ");
                int integerCount = scanner.nextInt();
                //create a blank list of Integer
                List<Integer> integers = new ArrayList<>();
                for (int i = 1; i <= integerCount; i++) {
                    System.out.println("enter integer "+i+" : ");
                    int integer = scanner.nextInt();
                    integers.add(integer);
                }
                //displaying list of integers
                System.out.println(integers);
                //calling the method below to remove even numbers
                System.out.println(removeEvenNumbers(integers));
                break;
            case 3:
                System.out.println("case3");
                System.out.println("how many integers do you want: ");
                int count = scanner.nextInt();
                //create blank arrayList of Integer
                List<Integer> integerList = new ArrayList<>();
                for (int i = 1; i <= count; i++) {
                    System.out.println("enter the "+i+" item : ");
                    Integer input = scanner.nextInt();
                    integerList.add(input);
                }
                //print raw arrayList
                System.out.println(integerList);
                //Predicate description
                System.out.println("Predicate : will return only less than 7");
                //creating a Predicate<T> that returns list with elements less than 7
                Predicate<Integer> predicate = x -> x<7;
                System.out.println(filterGenericList(integerList,predicate));
                break;
            case 4:
                System.out.println("case4");
                System.out.println("how many integers do you want to put on map: ");
                int itemsCount = scanner.nextInt();
                //create blank map of Integer
                //Map<K,V> java.util
                Map<Integer,Integer> map = new HashMap<>();
                for (int i = 1; i <= itemsCount; i++) {
                    System.out.println("enter the "+i+" key item : ");
                    int key = scanner.nextInt();
                    System.out.println("enter the "+i+" value item : ");
                    int value = scanner.nextInt();
                    map.put(key,value);
                }
                //printing raw values
                System.out.println(map);
                //BiPredicate description
                System.out.println("BiPredicate : will return only equal key-value pair from the map");
                //create a BiPredicate<T,U> java.util.function
                BiPredicate<Integer,Integer> biPredicate =
                        //x -> key & y -> value
                        //Integer (java.lang),
                        //.valueOf(int i) -> output : Integer
                        //.equals(Obj obj) -> output : boolean
                        (x,y) -> Integer.valueOf(x).equals(y);
                //
                System.out.println(filterGenericMap(map,biPredicate));
                break;
            case 5:
                System.out.println("case5");
                System.out.println("how many integers do you want: ");
                int counts = scanner.nextInt();
                //create blank arrayList of Integer
                List<Double> integerLists = new ArrayList<>();
                for (int i = 1; i <= counts; i++) {
                    System.out.println("enter the "+i+" item : ");
                    Double input = scanner.nextDouble();
                    integerLists.add(input);
                }
                //print raw arrayList
                System.out.println(integerLists);
                //Function description
                System.out.println("Function : will return square of a number");
                //creating Function
                //Function<T,R> java.util.function
                Function<Double,Double> function = x-> x*x;
                //print out the updated list
                System.out.println(updateList(integerLists,function));
                break;
            default:
                System.out.println("not a valid option");
                break;
        }


    }

    private static List<Double> updateList(List<Double> integerLists, Function<Double, Double> function) {
        //create a blank list of Double
        List<Double> doubles = new ArrayList<>();
        //we still can't use fori because of int i conflicting to the double parameter type
        for (Double item : integerLists){
            //adding the doubled values to blank list
            //.apply(Double t) -> output : Double
            doubles.add(function.apply(item));
        }
        return doubles;
    }

    //notice the parameter type
    private static <K,V> Map<K,V> filterGenericMap(Map<K,V> map, BiPredicate<K,V> biPredicate) {
        //creating blank map
        HashMap<K,V> newMap = new HashMap<>();
        //we can't use the fori loop here cause we need 2 parameter type for BiPredicate
        //so we use enhanced forLoop to settle the parameter type conflict
        //.Entry<K,V> java.util.map
        //.entrySet(K k, V v) -> output : Set<Entry<K,V>>
        for (Map.Entry<K,V> item : map.entrySet()){
            //.test(K t, V u) -> output : boolean
            if (biPredicate.test(item.getKey(),item.getValue())){
                 newMap.put(item.getKey(),item.getValue());
            }
        }
         return newMap;
    }

    //notice the parameter type
    private static <T> List<T> filterGenericList(List<T> integerList, Predicate<T> predicate) {
        //iterating on the integerList with T type
        for (int i = 0; i < integerList.size(); i++) {
            //using predicate to test the items from integerList
            //.test(T t) -> output : boolean
            if (predicate.test(integerList.get(i))){
                integerList.get(i);
            }else {
                integerList.remove(i);
                //need to decrease for every delete as the array size decreases
                i--;
            }
        }
        return integerList;
    }

    private static List<Integer> removeEvenNumbers(List<Integer> integers) {
        //filter even integers using removeIf(Predicate<? super Integer> filter ) -> output : boolean
        integers.removeIf(integer -> integer%2==0);
        return integers;
    }

    private static List<String> sortListByLength(List<String> strings) {
        //using .sort() method
        strings.sort((s, t1) -> {
            return  s.length()-t1.length();
        });
        //returning list of sorted strings
        return strings;
    }
}
