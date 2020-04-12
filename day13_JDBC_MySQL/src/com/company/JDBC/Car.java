package com.company.JDBC;

public class Car {
    private int id;
    private String model;
    private String make;
    private long year;
    private  double price;

    public Car(){}

    public Car(int id, String make, String model, long year, double price) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.year = year;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cars = id: " + id + ", model= " + model + ", make= " + make + ", year= "+year+", price= " + price;
    }
}
