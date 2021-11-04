package com.home.lab1;

//@credits: Andreea Draghici
//11.10.2021, 19:57

// Java code for thread creation by extending
// the Thread class
class MyThread implements Runnable {


    public void run() {
        int n=0;
        int temp = 0;
        int count;

        try {
            // Displaying the thread that is running
            System.out.println("\nThread is Running..." + "\n");
            //System.out.println("Thread " + Thread.currentThread().getId() + " is running" + "\n");
            count = 0;
            while (count < 10) {
                temp = n;
                n = temp + 1;
                System.out.println("Value of temp for thread  " +Thread.currentThread().getId()+" is "+ temp + " -> Value of n: " + n);
                count++;
            }
        } catch (Exception exp) {
            //Throwing an exception
            exp.printStackTrace();
        }

    }

}