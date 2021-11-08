package com.home.lab5.task3;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class TechLead extends Thread{
    CyclicBarrier cyclicBarrier;
    public TechLead(CyclicBarrier cyclicBarrier, String name) {
        super(name);
        this.cyclicBarrier= cyclicBarrier;
    }
    public void run() {
        try {
            Thread.sleep(3000);
            for (String s : Arrays.asList(" recruited developer", " waiting for others to complete ...")) {
                System.out.println(Thread.currentThread().getName()+ s);
            }
            cyclicBarrier.await();
            System.out.println("All finished recruiting, " + Thread.currentThread().getName() + " gives offer letter to candidate");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }}
