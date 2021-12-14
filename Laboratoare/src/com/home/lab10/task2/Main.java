package com.home.lab10.task2;

public class Main {
    static ProducerConsumer<String, String> e = new ProducerConsumer<String, String>();
    static Producer ionel = new Producer(e, "Ionel");
    static Producer gigel = new Producer(e, "Gigel");
    static Consumer maria = new Consumer(e);

    public static void main(String[] args) {
        Thread tIonel = new Thread(ionel);
        Thread tGigel = new Thread(gigel);
        Thread tMaria = new Thread(maria);

        tIonel.start();
        tGigel.start();
        tMaria.start();
    }

}
