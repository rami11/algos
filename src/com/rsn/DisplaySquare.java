package com.rsn;

public class DisplaySquare {

    public static void main(String[] args) {
        System.out.println("Square of length 4:");
        displaySquare(5);

        System.out.println();
        System.out.println();

        System.out.println("Square of length 6:");
        displaySquare2(6);

        System.out.println();
        System.out.println();

        System.out.println("Square of length 8:");
        displaySquare3(8);
    }

    private static void displaySquare(int length) {
        if (length <= 1) {
            System.out.println("*");
            return;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == 0 || i == length -1 || j == 0 || j == length - 1) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

    }

    private static void displaySquare2(int length) {
        if (length <= 1) {
            System.out.println("*");
            return;
        }

        String[][] square = new String[length][length];

        // fill horizontal lines
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < square.length; j++) {
                if (i == 0 || i == length -1 || j == 0 || j == length - 1) {
                    square[i][j] = "* ";
                } else {
                    square[i][j] = "  ";
                }
            }
        }

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                System.out.print(square[i][j]);
            }
            System.out.println();
        }
    }

    private static void displaySquare3(int length) {
        if (length <= 1) {
            System.out.println("*");
            return;
        }

        String[][] square = new String[length][length];

        // initiate two dimensional array
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                square[i][j] = " ";
            }
        }

        // fill horizontal lines
        for (int i = 0; i < length; i++) {
            square[0][i] = "*";
            square[length - 1][i] = "*";

            square[i][0] = "*";
            square[i][length - 1] = "*";
        }

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                System.out.print(square[i][j] + " ");
            }
            System.out.println();
        }
    }

}
