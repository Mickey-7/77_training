package com.company.Setter_Getter_toString_Constructors;

public class Shape {
    private int side;
    private String color;

    //blank constructor
    public Shape(){}

    //alt + insert - constructor
    public Shape(int side, String color) {
        this.side = side;
        this.color = color;
    }

    //constructor with one parameter only
    public Shape(int side) {
        this.side = side;
    }

    //making a Setter that uses switch case
    public void setColor(int color){
        switch (color){
            case 1:
                this.color = "red";
                break;
            case 2:
                this.color = "orange";
                break;
            case 3:
                this.color = "yellow";
                break;
            case 4:
                this.color = "blue";
                break;
            default:
                this.color = "white";
        }
    }

    //alt + insert - Getter and Setter
    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    //alt + insert - toString()
    @Override
    public String toString() {
        return "Shape{" +
                "side=" + side +
                ", color='" + color + '\'' +
                '}';
    }
}
