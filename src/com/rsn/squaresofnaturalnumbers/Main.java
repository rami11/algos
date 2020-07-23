package com.rsn.squaresofnaturalnumbers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input1.txt"))) {
            int n = scanner.nextInt();
            printSquares(n);
        }
    }

    private static void printSquares(int n) {
        int square;
        int i = 1;
        while ((square = (int) Math.pow(i++, 2)) <= n) {
            System.out.println(square);
        }
    }
}
