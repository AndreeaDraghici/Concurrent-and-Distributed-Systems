package com.home.lab7.task2;

import java.util.concurrent.ThreadLocalRandom;

public class Philosopher extends Thread {
    public int number;
    public Global leftFork;
    public Global rightFork;

    Philosopher(int num, Global left, Global right) {
        number = num;
        leftFork = left;
        rightFork = right;
    }

    public void run() {
        System.out.println("Philosopher #" + number);

        do {
            leftFork.grab();
            System.out.println("Philosopher #" + number + " grabs left fork.");
            rightFork.grab();
            System.out.println("Philosopher #" + number + " grabs right fork.");
            eat();
            leftFork.release();
            System.out.println("Philosopher #" + number + " releases left fork.");
            rightFork.release();
            System.out.println("Philosopher #" + number + " releases right fork.");
        } while (true);
    }

    void eat() {
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(0, 1000);
            System.out.println("Philosopher #" + " eats for " + sleepTime);
            Thread.sleep(sleepTime);
        } catch (Exception e) {
            System.out.println("Could not eat due to: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
