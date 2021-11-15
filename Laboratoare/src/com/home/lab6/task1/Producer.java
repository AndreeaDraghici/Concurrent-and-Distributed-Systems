package com.home.lab6.task1;


public class Producer extends Thread {
    int q, r, max, min; // min...max, din q in q, incepand cu restul r
    PCMonitor buffer;
    int c = 0; // Contor de elemente trimise

    public Producer(int q, int r, int min, int max, PCMonitor b) {
        this.q = q;
        this.r = r;
        this.min = min;
        this.max = max;
        this.buffer = b;
    }

    int getCounter() {
        return c;
    }

    public void run() {
        int i = min;
        while ((i % q) != r) {
            i++;
        } // determina primul numar produs
        while (i <= max) {
            buffer.append(i);
            c++;
            System.out.println("Producer " + r + " produced " + i);
            i += q;
        }
    }
}
