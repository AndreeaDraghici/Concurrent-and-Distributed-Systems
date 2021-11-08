package com.home.lab5.task1;

public class Main {
    public static void main(String[] args) {
        CountSum p = new CountSum();
        CountSum q = new CountSum();
        p.start();
        q.start();
        try {
            p.join();
            q.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final counter: " + p.getN());
    }
}
