package com.home.lab5.task4.a;

import java.util.concurrent.Semaphore;

public class CountSum extends Thread {
    static volatile int n = 0;
    Semaphore s = new Semaphore(1);

    public int getN() {
        return n;
    }

    public void run() {
        int temp;
        for (int i = 0; i < 10000000; i++) {
            try {
                s.acquire();
                temp = n;
                n = temp + 1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                s.release();
            }
        }
    }
}