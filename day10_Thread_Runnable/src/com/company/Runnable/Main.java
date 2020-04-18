package com.company.Runnable;

public class Main {
    public static void main(String[] args) {

        //Runnable - Java runnable is an interface used to execute code on a concurrent thread

        //Runnable
        Thread t1 = new Thread( new RunnablePractice());

        //using lambda
        Thread t2 = new Thread(()->{
            for (int i = 0; i < 7; i++) {
                System.out.println(i);
            }
        });

        t1.start();
        t2.start();

        //output
        //0
        //1
        //2
        //3
        //4
        //5
        //6
        //Thread ID 77256395-80b9-424d-832b-929311ac0525 : 0
        //Thread ID 77256395-80b9-424d-832b-929311ac0525 : 1
        //Thread ID 77256395-80b9-424d-832b-929311ac0525 : 2
        //Thread ID 77256395-80b9-424d-832b-929311ac0525 : 3
        //Thread ID 77256395-80b9-424d-832b-929311ac0525 : 4
        //Thread ID 77256395-80b9-424d-832b-929311ac0525 : 5
        //Thread ID 77256395-80b9-424d-832b-929311ac0525 : 6
    }
}
