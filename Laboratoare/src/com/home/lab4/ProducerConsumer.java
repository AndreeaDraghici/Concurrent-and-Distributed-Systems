package com.home.lab4;

import java.util.LinkedList;

public class ProducerConsumer {
    // Create a list shared by producer and consumer
    // Size of list is 2.
    LinkedList<Integer> list = new LinkedList<>();
    int capacity = 1;

    // called by producer thread
    public synchronized void produce() throws InterruptedException {
        int value = 0;
        // producer thread waits while list is full
        if (list.size() != capacity) {
        } else {
            do {
                wait();
            } while (list.size() == capacity);
        }

        System.out.println("#P# produced task => " + value);

        // add a task to the list
        list.add(value++);

        // notifies the consumer thread that
// now it can start consuming
        notify();

        // just for make the output more easy to read
        Thread.sleep(1000);
        do {
            if (value >= 5) {
                break;
            } else {// producer thread waits while list is full
                if (list.size() == capacity) {
                    do {
                        wait();
                    } while (list.size() == capacity);
                }

                System.out.println("#P# produced task => " + value);

                // add a task to the list
                list.add(value++);

                // notifies the consumer thread that
                // now it can start consuming
                notify();

                // just for make the output more easy to read
                Thread.sleep(1000);
            }
        } while (true);
    }

    // called by consumer thread
    public synchronized void consume() throws InterruptedException {
        do {
            // consumer thread waits while list
            // is empty
            while (list.size() == 0) {
                wait();
            }

            // to retrieve the first task in the list
            int val = list.removeFirst();

            System.out.println("#C# consumed task => " + val);

            // Wake up producer thread
            notify();

            // and sleep
            Thread.sleep(1000);
        } while (true);
    }
}
