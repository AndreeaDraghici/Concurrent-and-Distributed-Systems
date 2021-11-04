package com.home.lab2.task4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalStateException {
        int k, q, r;
        int start, stop;
        int terminatedThreads = 1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("k=");
        k = scanner.nextInt();

        System.out.println("q=");
        q = scanner.nextInt();

        System.out.println("r=");
        r = scanner.nextInt();
        scanner.close();

        var prime = new Prime[k];

        {
            int i = 0;
            while (i < k) {
                start = (i - 1) * q + r + 1;
                stop = i * q + r;

                prime[i] = new Prime(start, stop);
                prime[i].start();
                i++;
            }
        }


        while (k >= terminatedThreads) {
            int i = 0;
            if (i < k) {
                do {
                    if (prime[i].getState() == Thread.State.TERMINATED) {
                        terminatedThreads++;
                    }
                    i++;
                } while (i < k);
            }
            Thread p = new Thread();
            switch (p.getState()) {
                case TERMINATED -> {
                    ++terminatedThreads;
                }

            }
        }
        Util.getResults();
    }

}
