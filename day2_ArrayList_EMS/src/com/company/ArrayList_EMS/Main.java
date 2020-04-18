package com.company.ArrayList_EMS;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //creating ArrayList of workers object
        ArrayList<Worker> workerArrayList = new ArrayList<>();
        //single addition of worker object
        workerArrayList.add(new Worker((long) 1,"worker1"));
        //multiple addition of worker object
        {
            workerArrayList.add(new Worker((long) 2,"worker2"));
            workerArrayList.add(new Worker((long) 3,"worker3"));
        }
        System.out.println(workerArrayList);

        //creating ArrayList of supervisor object
        ArrayList<Supervisor> supervisorArrayList = new ArrayList<>();
        //single addition of supervisor object
        supervisorArrayList.add(new Supervisor((long) 1,"supervisor1",workerArrayList));
        //multiple addition of supervisor object
        {
            supervisorArrayList.add(new Supervisor((long) 2,"supervisor2",workerArrayList));
            supervisorArrayList.add(new Supervisor((long) 3,"supervisor3",workerArrayList));
        }
        System.out.println(supervisorArrayList);

        //creating a president object
        President president = new President((long) 1,"president1",supervisorArrayList);
        System.out.println(president);

        //to modify the output on console - we can edit the toString() method of each class

    }
}
