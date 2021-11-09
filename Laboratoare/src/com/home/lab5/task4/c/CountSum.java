package com.home.lab5.task4.c;

import java.util.concurrent.Semaphore;

public class CountSum extends Thread {
    static volatile int n = 0;
    static Semaphore s = new Semaphore(1);

    public int getN() {
        return n;
    }

    public void run() {
        int temp;

        try {
            s.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            for (int i = 0; i < 10000000; i++) {
                temp = n;
                n = temp + 1;
            }
            s.release();
        }
    }
}

