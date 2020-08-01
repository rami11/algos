package com.rsn.stack.interview;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10L);
        stack.push(20L);
        stack.push(30L);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
