package com.home.lab2.task1and2;

import java.util.stream.IntStream;

public class MyThread extends Thread {
    @Override
    public void run() {
        IntStream.range(0, 10).forEach(System.out::println);
    }
}
