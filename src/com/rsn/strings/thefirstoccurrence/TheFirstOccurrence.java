package com.rsn.strings.thefirstoccurrence;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TheFirstOccurrence {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input3.txt"))) {
            String pattern = scanner.nextLine();
            String text = scanner.nextLine();

            System.out.println(findFirstOccurrence(text, pattern));
        }
    }

    private static int findFirstOccurrence(String text, String pattern) {
        if (text.length() < pattern.length()) {
            return -1;
        }
        if (pattern.isEmpty()) {
            return 0;
        }
        for (int i = 0; i < text.length() - pattern.length() + 1; i++) {
            boolean isPatternFound = true;
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    isPatternFound = false;
                    break;
                }
            }
            if (isPatternFound) {
                return i;
            }
        }
        return -1;
    }
}
