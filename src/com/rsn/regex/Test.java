package com.rsn.regex;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
//    public static void main(String[] args) throws FileNotFoundException {
//        try (Scanner scanner = new Scanner(new FileReader("input2.txt"))) {
//            String part = scanner.nextLine();
//            String line = scanner.nextLine();
//            System.out.println(part);
//            System.out.println(line);
//
//            Pattern pattern = Pattern.compile(String.format("\\S+%s\\S+", part), Pattern.CASE_INSENSITIVE);
//            Matcher matcher = pattern.matcher(line);
//            System.out.println(matcher.find() ? "YES" : "NO");
//        }
//    }

//    public static void main(String[] args) throws FileNotFoundException {
//        try (Scanner scanner = new Scanner(new FileReader("in3.txt"))) {
//            int size = Integer.parseInt(scanner.nextLine());
//            String line = scanner.nextLine();
//            System.out.println(size);
//            System.out.println(line);
//
//            Pattern pattern = Pattern.compile(String.format("\\s+\\w{%d}\\s+", size));
//            Matcher matcher = pattern.matcher(line);
//            System.out.println(matcher.find() ? "YES" : "NO");
//        }
//    }

    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("i3.txt"))) {

            String text = scanner.nextLine();

            Pattern pattern = Pattern.compile("\\bpassword\\s*:?\\s*(\\w+)", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                do {
                    System.out.println(matcher.group(1));
                } while (matcher.find());
            } else {
                System.out.println("No passwords found.");
            }
        }
    }
}
