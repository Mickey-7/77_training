package com.company.Abstract;

public class Main {
    public static void main(String[] args) {

        //create Dog object in Animal class
        Animal dog = new Dog("doggy");
        System.out.println(dog.makeSound());

        //create Chicken object in Animal class
        Animal chicken = new Chicken("mankok na pula");
        System.out.println(chicken.makeSound());

        //using instanceof
        System.out.println(chicken instanceof Animal);
        System.out.println(chicken instanceof Dog);
        System.out.println(chicken instanceof Chicken);
    }
}
