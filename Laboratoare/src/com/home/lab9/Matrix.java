package com.home.lab9;

public class Matrix {
    int dim;
    double[][] data;
    int rowDisplace;
    int colDisplace;
    Matrix(int d) {
        dim = d;
        rowDisplace = colDisplace = 0;
        data = new double[d][d];
    }
    Matrix(double[][] matrix, int x, int y, int d) {
        data = matrix;
        rowDisplace = x;
        colDisplace = y;
        dim = d;
    }
    double get(int row, int col) {return data[row + rowDisplace][col + colDisplace];}
    void set(int row, int col, double value) {data[row + rowDisplace][col + colDisplace] = value;}
    public int getDim() {return dim;}
    Matrix[][] split() {
        Matrix[][] result = new Matrix[2][2];
        int newDim = dim / 2;
        result[0][0] = new Matrix(data, rowDisplace, colDisplace, newDim);
        result[0][1] = new Matrix(data, rowDisplace, colDisplace + newDim, newDim);
        result[1][0] = new Matrix(data, rowDisplace + newDim, colDisplace, newDim);
        result[1][1] = new Matrix(data, rowDisplace + newDim, colDisplace + newDim, newDim);
        return result;
    }
    public void printMatrix() {
        for (int i = 0; i <= rowDisplace; i++) {
            for (int j = 0; j <= colDisplace; j++) {
                System.out.print(this.data[i][j] + " ");
            }
            System.out.println();
        }
    }

}
