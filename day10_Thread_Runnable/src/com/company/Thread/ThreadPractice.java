package com.company.Thread;

//extends Thread
public class ThreadPractice extends Thread {

    //alt insert then choose override and select run():void

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("Thread ID "+this.getId()+" - "+i);
        }
    }
}
