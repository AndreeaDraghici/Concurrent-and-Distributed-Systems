package com.home.lab10.task2;

public class Consumer implements Runnable {
    private int c = 0;
    private ProducerConsumer<String, String> pc;

    public Consumer(ProducerConsumer<String, String> pc) {
        this.pc = pc;
    }

    public void run() {
        try {
            while (true) {
                String request = pc.accept();
                System.out.println("Accepter request" + ": " + request);
                String result = request + (++c);
                System.out.println("Accepter result" + ": " + result);
                pc.reply(result);
            }
        } catch (InterruptedException e) {
        }
    }

}
