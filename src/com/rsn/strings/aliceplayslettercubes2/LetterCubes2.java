package com.rsn.strings.aliceplayslettercubes2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class LetterCubes2 {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input1.txt"))) {
            String str = scanner.next();
            int count = countDistinctSubstrings(str);
            int countNaive = countDistinctSubstringsNaive(str);
            System.out.println("count: " + count);
            System.out.println("count naive: " + countNaive);
        }
    }

    static int countDistinctSubstringsNaive(String str) {
        Set<String> substringSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length() + 1; j++) {
                String substring = str.substring(i, j);
                substringSet.add(substring);
            }
        }
        return substringSet.size();
    }

    static int countDistinctSubstrings(String str) {
        int count = 2;
        for (int i = 2; i < str.length() + 1; i++) {
            StringBuilder substrBuilder = new StringBuilder(str.substring(0, i));
            String reverseSubstr = substrBuilder.reverse().toString();

            int maxPrefix = Arrays.stream(prefixFunction(reverseSubstr)).max().orElseThrow();
            count += reverseSubstr.length() - maxPrefix;
        }
        return count;
    }

    public static int[] prefixFunction(String str) {
        int[] prefixFunc = new int[str.length()];

        for (int i = 1; i < str.length(); i++) {
            int j = prefixFunc[i - 1];

            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixFunc[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j += 1;
            }
            prefixFunc[i] = j;
        }
        return prefixFunc;
    }
}
