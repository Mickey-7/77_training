package com.company.Runnable;

import java.util.UUID;

//implements Runnable
public class RunnablePractice implements Runnable {
    //for UUID
    private String id;

    public RunnablePractice() {
        //UUID java.util
        this.id = UUID.randomUUID().toString();
    }

    //hover on the class name then alt insert
    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Thread ID "+id+" : "+i);
        }
    }
}

