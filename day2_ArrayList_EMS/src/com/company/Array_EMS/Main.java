package com.company.Array_EMS;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //creating array of workers object
        Worker[] workers = new Worker[]{
                new Worker((long) 1,"worker1"),
                new Worker((long) 2,"worker2"),
                new Worker((long) 3,"worker3"),
        };
        //System.out.println(workers); will output [Lcom.company.Array_toString_EMS.Worker;@2d98a335
        //so we need to use Arrays.toString() method as workers is an array object
        System.out.println(Arrays.toString(workers));

        //creating array of supervisor object
        Supervisor[] supervisors = new Supervisor[]{
                new Supervisor((long) 1,"supervisor1",workers),
                new Supervisor((long) 2,"supervisor2",workers),
        };
        //System.out.println(supervisors); will output [Lcom.company.Array_toString_EMS.Worker;@2d98a335
        //so we need to use Arrays.toString() method as supervisors is an array object
        System.out.println(Arrays.toString(supervisors));

        //creating a president object
        President president = new President((long) 1,"president1",supervisors);
        //no need to call toString() method
        System.out.println(president);

        //to modify the output on console - we can edit the toString() method of each class

    }
}
