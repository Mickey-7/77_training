package com.company.Thread;

public class Main {
    public static void main(String[] args) {

        //Thread - JVM allows an application to have multiple threads of execution running concurrently
        //Threads with higher priority are executed in preference to threads with lower priority
        //Each thread may or may not also be marked as daemon.

        //Thread java.lang
        Thread t1 = new ThreadPractice();
        //thread using runnable interface
        t1.start();
        t1.run();
        //output - if either is executed
        //Thread ID 14 - 0
        //Thread ID 14 - 1
        //Thread ID 14 - 2
        //Thread ID 14 - 3
        //Thread ID 14 - 4
        //Thread ID 14 - 5
        //Thread ID 14 - 6
        //output - if both are executed
        //Thread ID 14 - 0
        //Thread ID 14 - 0
        //Thread ID 14 - 1
        //Thread ID 14 - 1
        //Thread ID 14 - 2
        //Thread ID 14 - 2
        //Thread ID 14 - 3
        //Thread ID 14 - 3
        //Thread ID 14 - 4
        //Thread ID 14 - 4
        //Thread ID 14 - 5
        //Thread ID 14 - 5
        //Thread ID 14 - 6
        //Thread ID 14 - 6

        Thread t2 = new ThreadPractice();
        t2.start();
        t2.run();
        //output - for t1.start() & t2.start()
        //Thread ID 14 - 0
        //Thread ID 15 - 0
        //Thread ID 14 - 1
        //Thread ID 15 - 1
        //Thread ID 14 - 2
        //Thread ID 15 - 2
        //Thread ID 14 - 3
        //Thread ID 15 - 3
        //Thread ID 14 - 4
        //Thread ID 15 - 4
        //Thread ID 14 - 5
        //Thread ID 15 - 5
        //Thread ID 14 - 6
        //Thread ID 15 - 6
        //output - for t1.run() & t2.run()
        //Thread ID 14 - 0
        //Thread ID 14 - 1
        //Thread ID 14 - 2
        //Thread ID 14 - 3
        //Thread ID 14 - 4
        //Thread ID 14 - 5
        //Thread ID 14 - 6
        //Thread ID 15 - 0
        //Thread ID 15 - 1
        //Thread ID 15 - 2
        //Thread ID 15 - 3
        //Thread ID 15 - 4
        //Thread ID 15 - 5
        //Thread ID 15 - 6







    }
}
