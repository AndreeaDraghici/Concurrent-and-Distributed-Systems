package com.home.lab2.task4;

import java.util.stream.IntStream;

public class Prime extends Thread {
    private final int start,stop;

    public Prime(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }
    @Override
    public void run() {
        checkInterval();
        this.stop();
    }

    public boolean isPrime(int number) {
        // Corner cases
        if (number > 1) {
            if (number > 3) {
                // This is checked so that we can skip
                // middle five numbers in below condition
                if (number % 2 != 0 && number % 3 != 0)
                    return IntStream.iterate(5, i -> i * i <= number, i -> i + 6)
                            .noneMatch(i -> number % i == 0 || number % (i + 2) == 0);
                else {
                    return false;
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    public void checkInterval() {
        int i = this.start;
        if (i <= this.stop) {
            do {
                if (isPrime(i) != true) {
                } else {
                    Util.addElement(i);
                }
                i++;
            } while (i <= this.stop);
        }
    }

}