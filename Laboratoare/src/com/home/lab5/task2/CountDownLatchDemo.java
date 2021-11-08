package com.home.lab5.task2;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String args[]) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(4);
        Worker first = new Worker(1000, latch, "WORKER-1");
        Worker second = new Worker(2000, latch, "WORKER-2");
        Worker third = new Worker(3000, latch, "WORKER-3");
        Worker fourth = new Worker(4000, latch, "WORKER-4");
        for (Worker worker : Arrays.asList(first, second, third, fourth)) {
            worker.start();
        }
        // The main task waits for four threads
        latch.await();
        // Main thread has started
        System.out.println(Thread.currentThread().getName() + " has finished");
    }
}
