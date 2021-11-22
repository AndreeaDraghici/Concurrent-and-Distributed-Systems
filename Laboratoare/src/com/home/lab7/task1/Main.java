package com.home.lab7.task1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        Queue<Integer> coada = new LinkedList<Integer>();
        ReentrantLock lock = new ReentrantLock();
        Condition cond = lock.newCondition();
        final int size = 5;
        Producer p1 = new Producer(lock, cond, coada, size, "1");
        Consumer c1 = new Consumer(lock, cond, coada, "1");
        Producer p2 = new Producer(lock, cond, coada, size, "2");
        Consumer c2 = new Consumer(lock, cond, coada, "2");
        p1.start();
        c1.start();
        p2.start();
        c2.start();
    }

}
