package com.home.lab6.task1;

public class PCMonitor {
    final int N = 5;
    int oldest = 0, newest = 0;
    volatile int count = 0;
    int buffer[] = new int[N];

    public synchronized void append(int v) {
        while (count == N) {
            try {
                wait(); // wait not full
            } catch
            (InterruptedException e) {
            }
        }
        buffer[newest] = v;
        newest = (newest + 1) % N;
        count++;
        notifyAll(); // signal not empty
    }

    synchronized int take() {
        int temp;
        while (count == 0) {
            try {
                wait(); // wait not empty
            } catch
            (InterruptedException e) {
            }
        }
        temp = buffer[oldest];
        oldest = (oldest + 1) % N;
        count--;
        notifyAll(); // signal not full
        return temp;
    }
}
