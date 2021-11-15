package com.home.lab6.task1;
public class Main {
    static final int NPTHREADS = 10;
    static final int NCTHREADS = 5;
    static final int MINN = 0;
    static final int MAXN = 76;
    static Producer pThreads[] = new Producer[NPTHREADS];
    static Consumer cThreads[] = new Consumer[NCTHREADS];
    static PCMonitor buffer = new PCMonitor();
    public static void main(String[] args) {
        int i;
        System.out.println("Producator - Consumator started");
        for (i = 0; i < NPTHREADS; i++) {
            pThreads[i] = new Producer(NPTHREADS, i, MINN, MAXN, buffer);
            pThreads[i].start();
        }
        for (i = 0; i < NCTHREADS; i++) {
            cThreads[i] = new Consumer(NCTHREADS, i, MINN, MAXN, buffer);
            cThreads[i].start();
        }
        for (i = 0; i < NPTHREADS; i++) {
            try {pThreads[i].join();
            } catch (InterruptedException e) {
            }
        }
        for (i = 0; i < NCTHREADS; i++) {
            try {cThreads[i].join();
            } catch (InterruptedException e) {
            }
        }
        for (i = 0; i < NPTHREADS; i++) {
            System.out.println("Producator " + i + " produced " + pThreads[i].getCounter() + " elements.");
        }
        for (i = 0; i < NCTHREADS; i++) {
            System.out.println("Consumator " + i + " consumed " + cThreads[i].getCounter() + " elements.");
        }
        System.out.println("Producator - Consumator finished");
    }
}