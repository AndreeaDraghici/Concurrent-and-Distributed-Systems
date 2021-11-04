package com.home.lab2.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Util {
    public static final ArrayList<Integer> primes = new ArrayList<>();

    public static void addElement(int element) {
        synchronized (primes) {
            primes.add(element);
            primes.notifyAll();
        }
    }
    public static void getResults() {
        Collections.sort(primes);
        System.out.println(Arrays.toString(primes.toArray()));
    }
}
