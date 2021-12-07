package com.home.lab9;

public class Main {
    public static void main(String[] argv) throws InterruptedException {
        double[][] a = {
                {1.0, 1.0},
                {1.0, 1.0},
        };
        double[][] b = {
                {1.0, 1.0},
                {1.0, 1.0},
        };
        double[][] c = {
                {0.0, 0.0},
                {0.0, 0.0},
        };
        Matrix firstMatrix = new Matrix(a, 1, 1, 1);
        Matrix secondMatrix = new Matrix(b, 1, 1, 1);
        Matrix thirdMatrix = new Matrix(c, 1, 1, 1);

        firstMatrix.printMatrix();
        System.out.println();

        AddTask addTask = new AddTask(firstMatrix, secondMatrix, thirdMatrix);
        Thread thread = new Thread(addTask);
        thread.start();
        thread.join();

        thirdMatrix.printMatrix();
        System.out.println();

        MultTask multTask = new MultTask(firstMatrix, secondMatrix, thirdMatrix);
        Thread thread1 = new Thread(String.valueOf(multTask));
        thread1.start();
        thread1.join();

        thirdMatrix.printMatrix();
    }

}
