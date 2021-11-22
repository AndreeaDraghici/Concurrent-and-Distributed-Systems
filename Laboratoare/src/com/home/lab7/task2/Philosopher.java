package com.home.lab7.task2;

import java.util.concurrent.ThreadLocalRandom;

public class Philosopher extends Thread {
    public int number;
    public Global leftFork;
    public Global rightFork;

    Philosopher(int num, Global left, Global right) {
        this.number = num;
        this.leftFork = left;
        this.rightFork = right;
    }

    public void run() {
        System.out.println("Philosopher " + number);
        try {
            while (true) {
                leftFork.grab();
                System.out.println("Philosopher " + number + " grabs left fork.");
                rightFork.grab();
                System.out.println("Philosopher " + number + " grabs right fork.");
                eat();
                think();
                leftFork.release();
                System.out.println("Philosopher " + number + " releases left fork.");
                rightFork.release();
                System.out.println("Philosopher " + number + " releases right fork.");
            }
        } catch (Exception e) {
            System.out.println("Philosopher " + number + " was interrupted.");
        }
    }

    private void eat() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 5);
            System.out.println("Philosopher " + " eats for " + sleepTime);
            Thread.sleep(5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void think() {
        try {
            System.out.println("Philosopher " + number + " is thinking.");
            System.out.flush();
            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
