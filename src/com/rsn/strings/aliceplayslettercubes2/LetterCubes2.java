package com.rsn.strings.aliceplayslettercubes2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class LetterCubes2 {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input3.txt"))) {
            String str = scanner.next();
            int count = countDistinctSubstrings2(str);
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
        if (str.isEmpty()) {
            return 1;
        }
        int count = 2;
        for (int i = 2; i < str.length() + 1; i++) {
            StringBuilder substrBuilder = new StringBuilder(str.substring(0, i));
            String reverseSubstr = substrBuilder.reverse().toString();

            int maxPrefix = Arrays.stream(prefixFunction(reverseSubstr)).max().orElseThrow();
            count += reverseSubstr.length() - maxPrefix;
        }
        return count;
    }

    static int countDistinctSubstrings2(String str) {
        int index = 0;
        int[] prefix;
        int noOfSubstrings = 1;
        String newStr = "";
        while (index < str.length()) {
            int len = newStr.length();
            newStr = str.charAt(index) + newStr;
            prefix = prefixFunction(newStr);
            noOfSubstrings += len + 1 - Arrays.stream(prefix).max().getAsInt();
            index++;
        }
        return noOfSubstrings;
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
