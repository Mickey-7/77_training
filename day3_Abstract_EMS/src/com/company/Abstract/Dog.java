package com.company.Abstract;

//need extends to Animal to inherit the abstract method makeSound() and the constructor
public class Dog extends Animal {

    //hover again on the class and select create constructor with super
    //change numFeet to 4 on super and remove numFeet parameter
    public Dog(String name) {
        super(name, 4);
    }

    //hover on the class and select implement method
    @Override
    public String makeSound() {
        return "arf arf";
    }
}
