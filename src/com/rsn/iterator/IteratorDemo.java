package com.rsn.iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Range range = new Range(2, 6);
//        Range range = new Range(2, 3);

        for (Long val : range) {
            System.out.println(val);
        }
    }
}
