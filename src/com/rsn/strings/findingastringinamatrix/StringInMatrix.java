package com.rsn.strings.findingastringinamatrix;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringInMatrix {

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input1.txt"))) {
            String pattern = scanner.next();
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();

            StringBuilder strBuilder = new StringBuilder();
            List<int[]> positions = new ArrayList<>();
            for (int i = 0; i < rows; i++) {
                strBuilder.append(scanner.next());
                for (int j = 0; j < cols; j++) {
                    int[] position = new int[2];
                    position[0] = i;
                    position[1] = j;
                    positions.add(position);
                }
            }

            String text = strBuilder.toString();
            List<Integer> occurrences = findOccurrences(text, pattern);
            List<int[]> result = occurrences.stream().map(positions::get).collect(Collectors.toList());
            System.out.println(result.size());
            result.forEach(position -> System.out.println(position[0] + " " + position[1]));
        }
    }

    static List<Integer> findOccurrences(String text, String pattern) {
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
