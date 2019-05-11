package com.rsn.reader;

import java.util.Scanner;

public class PositiveNumberReader {

    public static void main(String[] args) {

        long n = readPositiveNumber();

        System.out.print("Factorial of " + n + ": ");
        System.out.println(factorial(n));

    }

    private static long readPositiveNumber() {
        long n;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter something: ");
                n = scanner.nextLong();
                while (n < 0) {
                    System.out.print("Please, enter a positive number: ");
                    n = scanner.nextLong();
                }
                break;

            } catch (Exception ex) {
                System.out.println("Invalid entry");
            }
        }

        return n;
    }

    private static long factorial(long n) {
        long f = 1;
        for (long i = n; i > 1; i--) {
            f *= i;
        }
        return f;
    }
}
