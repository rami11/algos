package com.rsn.multidimarray.checksudoku;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.stream.IntStream;

public class CheckSudokuDemo {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input4.txt"))) {
            int n = scanner.nextInt();

            int[] input = new int[n * n * n * n];
            int index = 0;
            int[][] sudoku = new int[n * n][n * n];
            for (int i = 0; i < n * n; i++) {
                for (int j = 0; j < n * n; j++) {
                    int next = scanner.nextInt();
                    sudoku[i][j] = next;
                    input[index++] = next;
                }
            }

            boolean isSolvedSudoku = true;
            if (!checkRowsAndCols(sudoku)) {
                isSolvedSudoku = false;
            } else {
                int[][][][] arrayOfArrays = new int[n][n][n][n];

                index = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        for (int k = 0; k < n; k++) {
                            for (int l = 0; l < n; l++) {
                                arrayOfArrays[i][j][k][l] = input[index++];
                            }
                        }
                    }
                }

                List<int[]> listOfVectors = new ArrayList<>();
                for (int[][][] rowOfArrays : arrayOfArrays) {
                    for (int[][] array : rowOfArrays) {
                        listOfVectors.addAll(Arrays.asList(array));
                    }
                }

                List<int[]> list = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    List<int[]> anotherList = new ArrayList<>();
                    for (int j = i; j < listOfVectors.size(); j += n) {
                        anotherList.add(listOfVectors.get(j));
                    }
                    list.addAll(anotherList);
                }

                List<int[][]> listOfArrays = new ArrayList<>();
                for (int i = 0; i < list.size(); i += n) {
                    int[][] arr = new int[n][n];
                    int k = i;
                    for (int j = 0; j < n; j++) {
                        arr[j] = list.get(k++);
                    }
                    listOfArrays.add(arr);
                }

                for (int[][] array : listOfArrays) {
                    if (!checkSubArray(array)) {
                        isSolvedSudoku = false;
                        break;
                    }
                }

            }
            System.out.println(isSolvedSudoku ? "YES" : "NO");
        }
    }

    private static void displayArray(int[][][] array) {
        for (int[][] arr : array) {
            for (int[] row : arr) {
                for (int element : row) {
                    System.out.print(element + " ");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void displayArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkRowsAndCols(int[][] array) {
        int n = array.length;
        int sum = IntStream.rangeClosed(1, n).sum();

        List<Set<Integer>> rowList = new ArrayList<>();
        List<Set<Integer>> columnList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            Set<Integer> rowSet = new HashSet<>();
            Set<Integer> columnSet = new HashSet<>();

            for (int j = 0; j < array[i].length; j++) {
                rowSet.add(array[i][j]);
                columnSet.add(array[j][i]);
            }
            rowList.add(rowSet);
            columnList.add(columnSet);
        }

        // check rows
        for (Set<Integer> set : rowList) {
            int sumSet = set.stream().reduce(Integer::sum).orElseThrow();
            if (set.size() != n || sumSet != sum) {
                return false;
            }
        }

        // check cols
        for (Set<Integer> set : columnList) {
            int sumSet = set.stream().reduce(Integer::sum).orElseThrow();
            if (set.size() != n || sumSet != sum) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSubArray(int[][] array) {
        int n = (int) Math.pow(array.length, 2);
        int sumOfElements = IntStream.rangeClosed(1, n).sum();

        int sum = 0;
        for (int[] row : array) {
            for (int element : row) {
                sum += element;
            }
        }
        return sumOfElements == sum;
    }

}
