package com.rsn.multidimarray.maxelementinmatrix;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaxElementInMatrixDemo {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input2.txt"))) {
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            int[][] array = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }

            int[] maxIndexes = findMaxIndexes(array);
            System.out.println(Arrays.toString(maxIndexes) + '\n');

            System.out.println("The array:");
            for (int[] row : array) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }
    }

    private static int[] findMaxIndexes(int[][] array) {
        int max = Integer.MIN_VALUE;
        int maxI = -1, maxJ = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int element = array[i][j];
                if (element > max) {
                    max = element;
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        return new int[]{maxI, maxJ};
    }

    /**
     * Unnecessarily complex
     */
    private static int[] findMaxIndexesComplex(int[][] array) {
        int max = Integer.MIN_VALUE;
        List<int[]> maxIndexList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int element = array[i][j];
                if (element > max) {
                    max = element;
                    maxIndexList.clear();
                    maxIndexList.add(new int[]{i, j});
                } else if (element == max) {
                    maxIndexList.add(new int[]{i, j});
                }
            }
        }

        maxIndexList.sort((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        return maxIndexList.get(0);
    }
}
