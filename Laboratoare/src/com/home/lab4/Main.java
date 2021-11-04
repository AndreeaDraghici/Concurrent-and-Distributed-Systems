package com.home.lab4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final ProducerConsumer producerConsumer = new ProducerConsumer();

        //create ProducerThread
        Thread t1 = new Thread(new ProducerThread(producerConsumer));

        //Create ConsumerThread
        Thread t2 = new Thread(String.valueOf(new ConsumerThread(producerConsumer)));

        // Start both threads
        t1.start();
        t2.start();
    }
}
