package com.home.lab10.task1;


public class Accepter implements Runnable {
    private int c = 0;
    private Entry<String, String> entry;

    public Accepter(Entry<String, String> e) {
        entry = e;
    }

    public void run() {
        try {
            do {
                String request = entry.accept();
                System.out.println("Accepter request" + ": " + request);
                String result = request + (++c);
                System.out.println("Accepter result" + ": " + result);
                entry.reply(result);
            } while (true);
        } catch (InterruptedException e) {
        }
    }

}
