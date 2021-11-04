package com.home.lab1;

//@credits: Andreea Draghici
//11.10.2021, 19:57

public class RunningThread {
    public static void main(String[] args) {

        MyThread counting1 = new MyThread();
        Thread thread1 = new Thread(counting1);
        thread1.start();


    }
}