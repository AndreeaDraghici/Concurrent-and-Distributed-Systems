package com.home.lab2.task5;

import java.util.stream.IntStream;

public class HorseThread extends Thread {
    private int number;

    public HorseThread(int number) {
        this.number = number;
    }

    public void run() {
        IntStream.range(0, 20).forEach(i -> {
            System.out.println("Horse with number " + number + " it makes move " + (i + 1));
            try {
                Thread.sleep(600);
            } catch (InterruptedException e) {
                System.out.println(e);
            } finally {
                if (Won.won) {
                    return;
                } else if ((i + 1) != 20) {
                    return;
                }
                Won.won = true;
                System.out.println("\nHORSE " + number + " HAS WON!!");
            }
        });
    }
}
