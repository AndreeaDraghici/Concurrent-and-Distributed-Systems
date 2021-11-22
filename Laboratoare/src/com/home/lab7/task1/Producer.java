package com.home.lab7.task1;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;
import java.util.stream.IntStream;

public class Producer extends Thread {
    ReentrantLock lock;
    Condition cond;
    Queue<Integer> coada;
    int size;
    String name;

    public Producer(ReentrantLock lock, Condition cond, Queue<Integer> coada, int size, String name) {
        this.lock = lock;
        this.cond = cond;
        this.coada = coada;
        this.size = size;
        this.name = name;
    }

    public void run() {
        IntStream.range(0, 10).forEachOrdered(i -> {
            lock.lock();
            while (true) {
                if (coada.size() != size) break;
                try {
                    cond.await();
                } catch (InterruptedException ex) {
                    System.out.println("Could not run thread due to: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
            coada.add(i);
            System.out.println("Producer : " + name + " Produced : " + i);
            cond.signal();
            lock.unlock();
        });
    }
}
