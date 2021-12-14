package com.home.lab10.task1;

import java.util.LinkedList;
import java.util.Queue;

public class Port<T> {
    Queue<T> queue = new LinkedList<T>();
    int ready = 0;

    public synchronized void send(T v) {
        queue.add(v);
        ++ready;
        notifyAll();
    }

    public synchronized T receive() throws InterruptedException {
        while (ready == 0) wait();
        --ready;
        return queue.remove();
    }

}
