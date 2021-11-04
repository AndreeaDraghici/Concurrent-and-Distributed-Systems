package com.home.lab2.task5;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        HorseThread[] horse = new HorseThread[20];
        final int N = 20;
        IntStream.range(0, N).forEach(i -> horse[i] = new HorseThread(i + 1));
        IntStream.range(0, N).forEach(i -> horse[i].start());
    }
}
