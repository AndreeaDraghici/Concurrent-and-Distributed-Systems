package com.home.lab10.task2;

public class Channel<T> {
    private T chan = null;
    int ready = 0;

    public synchronized void send(T mes) throws InterruptedException {
        chan = mes;

        ++ready;
        notifyAll();

        while (chan != null) {
            wait();
        }
    }

    public synchronized T receive() throws InterruptedException {

        while (ready == 0) {
            wait();
        }

        --ready;
        T tmp = chan;
        chan = null;

        notifyAll();

        return (tmp);
    }

}
