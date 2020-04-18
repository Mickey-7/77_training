package com.company.Abstract;

//need extends to Animal to inherit the abstract method makeSound() and the constructor
public class Chicken extends Animal{
    private int numEggs;

    //hover again on the class and select create constructor with super
    //change numFeet to 4 on super and remove numFeet parameter
    public Chicken(String name) {
        super(name, 2);
    }

    //hover on the class and select implement method
    @Override
    public String makeSound() {
        return "tiktilaok";
    }

    public int getNumEggs() {
        return numEggs;
    }

    public void setNumEggs(int numEggs) {
        this.numEggs = numEggs;
    }
}
