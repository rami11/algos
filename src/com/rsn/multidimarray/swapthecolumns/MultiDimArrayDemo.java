package com.rsn.multidimarray.swapthecolumns;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MultiDimArrayDemo {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input1.txt"))) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            int[][] array = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            for (int row = 0; row < rows; row++) {
                int temp = array[row][j];
                array[row][j] = array[row][i];
                array[row][i] = temp;
            }

            for (int[] vector : array) {
                for (int element : vector) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }
    }
}
