package com.home.lab10.task2;

public class Producer implements Runnable {
    private ProducerConsumer<String, String> pc;
    private String id;

    public Producer(ProducerConsumer<String, String> pc, String s) {
        this.pc = pc;
        id = s;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Caller " + id + " parameter: " + id);
                String result = pc.call(id);
                System.out.println("Caller " + id + " result: " + result);
            }
        } catch (InterruptedException e) {
        }
    }

}
