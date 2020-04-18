package com.company.Abstract;

//declaring class as abstract
public abstract class Animal {
    private String name;
    private int numFeet;

    //below is the abstract method
    public abstract String makeSound();

    public Animal(String name, int numFeet) {
        this.name = name;
        this.numFeet = numFeet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumFeet() {
        return numFeet;
    }

    public void setNumFeet(int numFeet) {
        this.numFeet = numFeet;
    }
}
