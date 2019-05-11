package com.rsn.middleword;

public class MiddleWord {

    public static void main(String[] args) {
        System.out.println(getMiddle("test"));
        System.out.println(getMiddle("testing"));

        System.out.println(getMiddle("t"));

    }

    public static String getMiddle(String word) {
        int length = word.length();
        return length % 2 == 0 ? word.substring(length / 2 - 1, length / 2 + 1) : String.valueOf(word.charAt(length / 2));
    }
}
