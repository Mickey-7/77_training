package com.company.Exercise;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //scanner to accept object values
        //scanner to ask for numbers of supervisor and worker
        //create addSupervisor & addWorker

        //creating President object
        President president = new President();
        System.out.println("enter president name: ");
        Scanner scanner = new Scanner(System.in);
        String presName = scanner.nextLine();
        president.setName(presName);
        System.out.println("Hello! "+presName);
        System.out.println("enter president id: ");
        long presId = scanner.nextLong();
        president.setId(presId);
        System.out.println("your id is: "+presId);

        System.out.println("what would you like to do?\n" +
                "1) Add Supervisor\n" +
                "2) Add Worker\n" +
                "3) Exit");
        int toDo = scanner.nextInt();


        //create blank ArrayList of Supervisor object - need to create it here so that it will not overwrite its previous values
        ArrayList<Supervisor> supervisors = new ArrayList<>();
        //if we create blank ArrayList of Worker object just like below:
        //global declaration - workers will be shared on all supervisors
//        ArrayList<Worker> workers = new ArrayList<>();

        //boolean to go inside the whileLoop
        boolean status = true;
        while (status){
            while (toDo==1){
                //if we create blank ArrayList of Supervisor object just like below:
//                ArrayList<Supervisor> supervisors = new ArrayList<>();
                //supervisors arrayList will be for this loop only, so need to declare it above to avoid overwriting previous values
                System.out.println("how many supervisors you want? ");
                int supCount = scanner.nextInt();
                for (int i = 0; i < supCount; i++) {
                    //create blank supervisor class object - need to declare it here so that the supervisor object will overwrite its previous values
                    Supervisor supervisor = new Supervisor();
                    System.out.println("enter supervisor id: ");
                    int supId = scanner.nextInt();
                    supervisor.setId((long) supId);
                    System.out.println("enter supervisor name: ");
                    String supName = scanner.next();
                    supervisor.setName(supName);

                    //create blank ArrayList of Worker object - need to declare it here so that the worker arrayList will overwrite its previous values
                    ArrayList<Worker> workers = new ArrayList<>();
                    //worker arrayList will only be for this loop
                    System.out.println("how many workers you want? ");
                    int workerCount = scanner.nextInt();
                    for (int j = 0; j < workerCount; j++) {
                        //create blank worker class object - need to declare it here so that the worker object will overwrite its previous values
                        Worker worker = new Worker();
                        System.out.println("enter worker id: ");
                        int workerId = scanner.nextInt();
                        worker.setId((long) workerId);
                        System.out.println("enter worker name: ");
                        String workerName = scanner.next();
                        worker.setName(workerName);
                        //add worker object to worker arrayList
                        workers.add(worker);
                        System.out.println(workers);
                    }
                    //add worker arrayList to supervisor object
                    supervisor.setWorkers(workers);
                    //add supervisor object to supervisors arrayList
                    supervisors.add(supervisor);
                }
                //add supervisors arrayList to president
                president.setSupervisors(supervisors);
                System.out.println(president);

                //going back to menu
                System.out.println("what would you like to do?\n" +
                        "1) Add Supervisor\n" +
                        "2) Add Worker\n" +
                        "3) Exit");
                toDo = scanner.nextInt();

            }
            while (toDo==2){
                //create blank ArrayList of Worker object - need to declare it here so that the worker arrayList will overwrite its previous values
                ArrayList<Worker> workers = new ArrayList<>();
                //declaration of data above will only be for this loop
                System.out.println("how many workers you want? ");
                int workerCount = scanner.nextInt();
                for (int i = 0; i < workerCount; i++) {
                    //create blank worker class object - need to declare it here so that the worker object will overwrite its previous values
                    Worker worker = new Worker();
                    System.out.println("enter worker id: ");
                    int workerId = scanner.nextInt();
                    worker.setId((long) workerId);
                    System.out.println("enter worker name: ");
                    String workerName = scanner.next();
                    worker.setName(workerName);
                    //add worker object to workers arrayList
                    workers.add(worker);
                    System.out.println(workers);
                }


                //create blank supervisor class object - no overwriting will happen on supervisor object as is it not in loop instead it will be added to supervisors arrayList
                Supervisor supervisor = new Supervisor();
                System.out.println("enter supervisor id: ");
                int supId = scanner.nextInt();
                supervisor.setId((long) supId);
                System.out.println("enter supervisor name: ");
                String supName = scanner.next();
                supervisor.setName(supName);
                //add workers arrayList to supervisor object
                supervisor.setWorkers(workers);
                System.out.println(supervisor);
                //add supervisor object to supervisor arrayList
                supervisors.add(supervisor);
                //add supervisors arrayList to president
                president.setSupervisors(supervisors);
                System.out.println(president);

                //going back to menu
                System.out.println("what would you like to do?\n" +
                        "1) Add Supervisor\n" +
                        "2) Add Worker\n" +
                        "3) Exit");
                toDo = scanner.nextInt();
            }
            while (toDo==3){
                System.out.println("exiting program!........");
                status = false;
                break;
            }
        }


    }



}
