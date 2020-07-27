package com.rsn.strings.aliceplayslettercubes;

//Alice likes playing letter cubes.
// She has constructed a word from them and some of the cubes remain unused.
// Now, she chooses a new cube from the unused ones and adds it to the beginning of the current word.
// The question that wonders her a lot: how many new subwords does the cube add to the current word?
// Your task here is to write a program that helps Alice answer her question.
//
//        Input: the first line contains a string s. The second line contains an integer k.
//        The third line contains kk symbols separated by spaces.
//
//        Output: for each symbol cc from the input, print the number of distinct substrings in a string cs that are not presented in a string ss.
//        All numbers should be separated by spaces.

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class LetterCubes {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input2.txt"))) {
            String str = scanner.next();
            int k = scanner.nextInt();
            for (int i = 0; i < k; i++) {
                String c = scanner.next();
                int count = countDistinctSubstrings(str, c);
                System.out.print(count + " ");
            }
        }
    }

    static int countDistinctSubstrings(String str, String symbol) {
        String extendedStr = symbol + str;
        int count = 0;
        for (int i = 1; i < extendedStr.length() + 1; i++) {
            String substr = extendedStr.substring(0, i);
            if (!str.contains(substr)) {
                count++;
            }
        }
        return count;
    }
}
