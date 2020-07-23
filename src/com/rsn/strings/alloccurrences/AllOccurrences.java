package com.rsn.strings.alloccurrences;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllOccurrences {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input1.txt"))) {
            String pattern = scanner.nextLine();
            String text = scanner.nextLine();

            List<Integer> result = findAllOccurrences(text, pattern);
            System.out.println(result.size());
            result.forEach(index -> System.out.print(index + " "));
        }
    }


    private static List<Integer> findAllOccurrences(String text, String pattern) {
        List<Integer> occurrenceIndexes = new ArrayList<>();
        if (pattern.isEmpty()) {
            occurrenceIndexes.add(0);
            return occurrenceIndexes;
        }
        if (pattern.length() > text.length()) {
            return occurrenceIndexes;
        }
        int index = 0;
        do {
            index = text.indexOf(pattern, index);
            if (index == -1) {
                break;
            } else {
                occurrenceIndexes.add(index);
                index++;
            }
        } while (true);
        return occurrenceIndexes;
    }
}
