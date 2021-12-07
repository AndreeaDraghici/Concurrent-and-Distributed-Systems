package com.home.lab9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AddTask implements Runnable {
    ExecutorService exec = Executors.newFixedThreadPool(4);
    Matrix a, b, c;
    public AddTask(Matrix a, Matrix b, Matrix c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public void run() {
        try {
            int n = a.getDim();
            if (n == 1) {
                c.set(0, 0, a.get(0, 0) + b.get(0, 0));
            } else {
                Matrix[][] aa = a.split(), bb = b.split(), cc = c.split();
                Future<?>[][] future = (Future<?>[][]) new Future[2][2];
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        future[i][j] = exec.submit(new AddTask(aa[i][j], bb[i][j], cc[i][j]));
                    }
                }
                for (int i = 0; i < 2; i++) {
                    for (int j = 0; j < 2; j++) {
                        future[i][j].get();
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
