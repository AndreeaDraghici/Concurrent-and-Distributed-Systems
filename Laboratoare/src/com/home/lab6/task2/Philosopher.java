package com.home.lab6.task2;

public class Philosopher extends Thread {
    public Monitor monitor;
    public int ID;

    public Philosopher(Monitor monitor, int ID) {
        this.monitor = monitor;
        this.ID = ID;
    }

    public void run() {
        do {
            monitor.go(ID);
        } while (true);
    }

}
