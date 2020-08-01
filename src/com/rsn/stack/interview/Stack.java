package com.rsn.stack.interview;

public class Stack {
    static int index = 0;
    Long[] array = new Long[10];

    public static void main(String[] args) {
        final Stack stack = new Stack();
        stack.push(5L);
        System.out.println(stack.pop());
    }

    public void push(Long i) {
        array[index++] = i;
    }

    public Long pop() {
        if (index == 0) {
            return null;
        } else {
            return array[--index];
        }

    }
}
