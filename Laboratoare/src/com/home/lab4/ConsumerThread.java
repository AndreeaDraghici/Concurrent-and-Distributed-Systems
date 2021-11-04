package com.home.lab4;

public class ConsumerThread implements Runnable {
    ProducerConsumer producerConsumer;

    public ConsumerThread(ProducerConsumer _producerConsumer) {
        this.producerConsumer = _producerConsumer;
    }

    @Override
    public void run() {
        try {
            producerConsumer.consume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
