package com.company.Generics;

//The T type indicates that it can be any type (like String, Integer, and Employee).
//The type you specify for the class will be used to store and retrieve the data.
public class Envelope<T> {
    private T object;

    public Envelope(T object) {
        this.object = object;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
