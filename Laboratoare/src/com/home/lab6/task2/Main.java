package com.home.lab6.task2;

import java.util.stream.IntStream;

public class Main {
    public static void main(String args[]) throws InterruptedException {
        Monitor monitor = new Monitor(Global.getNum());
        Philosopher P[] = IntStream.range(0, Global.getNum()).mapToObj(i -> new Philosopher(monitor, i)).toArray(Philosopher[]::new);
        IntStream.range(0, Global.getNum()).forEachOrdered(i -> {
            P[i].start();
        });
        int i = Global.getNum() - 1;
        if (i >= 0) {
            do {
                P[i].join();
                i--;
            } while (i >= 0);
        }
    }
}
