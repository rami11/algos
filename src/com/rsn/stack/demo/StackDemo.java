package com.rsn.stack.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class StackDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader("input4.txt"));
        String str = scanner.next();
        Deque<Character> stack = new ArrayDeque<>();

        boolean isBalanced = true;
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.offerLast(c);
            } else {
                Character b = stack.pollLast();
                if (b == null) {
                    isBalanced = false;
                    break;
                }
                if (c == ')' && b != '(' || c == ']' && b != '[' || c == '}' && b != '{') {
                    break;
                }
            }
        }
        isBalanced &= stack.isEmpty();
        System.out.println(isBalanced);
    }
}
