package com.home.lab7.task2;

import java.util.concurrent.locks.ReentrantLock;

public class Global extends Thread {
    ReentrantLock lock;

    Global() {
        lock = new ReentrantLock();
    }

    void grab() {
        try {
            if (lock.tryLock())
                lock.lock();
        } catch (Exception e) {
            System.out.println("Could not grab due to: " + e.getMessage());
            e.printStackTrace();
        }
    }

    void release() {
        lock.unlock();
    }
}
