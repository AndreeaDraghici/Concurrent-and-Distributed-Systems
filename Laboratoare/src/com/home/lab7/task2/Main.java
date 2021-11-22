package com.home.lab7.task2;

import java.util.stream.IntStream;

public class Main {
    static Philosopher philosophers[] = new Philosopher[5];
    static Global forks[] = new Global[5];

    public static void main(String argv[]) {

        IntStream.range(0, 5).forEach(i -> forks[i] = new Global());
        IntStream.range(0, 5).forEachOrdered(i -> {
            philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % 5]);
            philosophers[i].start();
        });
    }
}
