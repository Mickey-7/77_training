package com.company.Setter_Getter_toString_Constructors;

public class Main {
    public static void main(String[] args) {
        //creating blank Shape object
        Shape triangle = new Shape();
        triangle.setSide(3);
        triangle.setColor("blue");
        System.out.println(triangle.getSide());
        System.out.println(triangle.getColor());
        System.out.println(triangle);

        //creating blank Shape object
        Shape quadrilateral = new Shape();
        quadrilateral.setSide(4);
        //using setter with switch case
        quadrilateral.setColor(2);
        System.out.println(quadrilateral.getSide());
        System.out.println(quadrilateral.getColor());
        System.out.println(quadrilateral);

        //creating object with constructor parameters
        Shape pentagon = new Shape(5,"purple");
        Shape hexagon = new Shape(6);
        System.out.println(pentagon.getSide());
        System.out.println(pentagon.getColor());
        System.out.println(hexagon.getSide());

        System.out.println(triangle.toString());
        System.out.println(quadrilateral.toString());
        System.out.println(pentagon.toString());
        System.out.println(hexagon.toString());

    }
}
