package com.home.lab4;

public class ProducerThread implements Runnable {
    ProducerConsumer producerConsumer;

    public ProducerThread(ProducerConsumer _producerConsumer) {
        this.producerConsumer = _producerConsumer;
    }

    @Override
    public void run() {
        try {
            producerConsumer.produce();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
