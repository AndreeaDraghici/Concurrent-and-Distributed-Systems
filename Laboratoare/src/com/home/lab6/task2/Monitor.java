package com.home.lab6.task2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class Monitor {

    private final ReentrantLock entLock;
    private final Condition self[];
    private int state[];

    public Monitor(int num) {
        entLock = new ReentrantLock();
        self = new Condition[num];
        state = new int[num];

        int i = 0;
        if (i < num) {
            do {
                self[i] = entLock.newCondition();
                state[i] = STATE.THINKING;
                i++;
            } while (i < num);
        }
    }

    void go(int who) {
        try {
            pickup(who);
            putdown(who);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    void pickup(int who) throws InterruptedException {
        entLock.lock();
        state[who] = STATE.HUNGRY;
        System.out.println("Philosopher " + who + " is hungry.\n");
        Test(who);

        switch (state[who]) {
            case STATE.EATING:
                break;
            default:
                self[who].await();
                break;
        }
        entLock.unlock();
    }

    void Test(int who) {
        if (state[Global.Left(who)] == STATE.EATING || state[Global.Right(who)] == STATE.EATING || state[who] != STATE.HUNGRY) {
            return;
        } else {
            state[who] = STATE.EATING;
            System.out.println("Philosopher " + who + " is eating.\n");
            self[who].signal();
        }
    }

    void putdown(int who) {
        entLock.lock();
        state[who] = STATE.THINKING;
        System.out.println("Philosopher " + who + " is thinking.\n");
        IntStream.of(Global.Left(who), Global.Right(who)).forEach(this::Test);
        entLock.unlock();
    }
}
