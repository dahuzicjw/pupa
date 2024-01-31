package com.github.basis.collection;

import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        Stack<Object> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        // remove the object at the top of this stack and return that
        System.out.println(stack.pop());
        // just get the top element
        System.out.println(stack.peek());
    }
}
