package com.home.lab5.task3;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

public class HRManager {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        TechLead techLead1 = new TechLead(cyclicBarrier, "John TL");
        TechLead techLead2 = new TechLead(cyclicBarrier, "Doe TL");
        TechLead techLead3 = new TechLead(cyclicBarrier, "Mark TL");
        for (TechLead techLead : Arrays.asList(techLead1, techLead2, techLead3)) {
            techLead.start();
        }
        System.out.println("No work");
    }
}
