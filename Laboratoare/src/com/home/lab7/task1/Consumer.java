package com.home.lab7.task1;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Consumer extends Thread {

    ReentrantLock lock;
    Condition cond;
    Queue<Integer> coada;
    String name;

    public Consumer(ReentrantLock lock, Condition cond, Queue<Integer> coada, String name) {
        this.lock = lock;
        this.cond = cond;
        this.coada = coada;
        this.name = name;
    }

    public void run() {
        IntStream.range(0, 10).forEachOrdered(i -> {
            lock.lock();
            while (true) {
                if (coada.size() >= 1) break;
                try {
                    cond.await();
                } catch (InterruptedException ex) {
                    System.out.println("Could not run thread due to: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
            System.out.println("Consumer : " + name + " Consumed : " + coada.remove());
            cond.signalAll();
            lock.unlock();
        });
    }
}
