package com.home.lab10.task1;

public class Caller implements Runnable {

    private Entry<String, String> entry;
    private String id;

    public Caller(Entry<String, String> e, String s) {
        entry = e;
        id = s;
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Caller " + id + " parameter: " + id);
                String result = entry.call(id);
                System.out.println("Caller " + id + " result: " + result);
            }
        } catch (InterruptedException e) {
        }
    }

}
