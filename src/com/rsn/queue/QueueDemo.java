package com.rsn.queue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class QueueDemo {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileReader("input1.txt"))) {
            int n = scanner.nextInt();

            Queue<Integer> queue1 = new ArrayDeque<>();
            Queue<Integer> queue2 = new ArrayDeque<>();
            int load1 = 0;
            int load2 = 0;
            while (n-- > 0) {
                int id = scanner.nextInt();
                int load = scanner.nextInt();
                if (load2 >= load1) {
                    queue1.offer(id);
                    load1 += load;
                } else {
                    queue2.offer(id);
                    load2 += load;
                }
            }
            queue1.forEach(element -> System.out.print(element + " "));
            System.out.println();
            queue2.forEach(element -> System.out.print(element + " "));
        }
    }
}
