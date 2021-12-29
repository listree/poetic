package com.leetcode.design;

import java.util.*;

/**
 * https://leetcode.com/problems/min-stack/
 * 155. Min Stack (Easy)
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * Runtime: 6 ms, faster than 67.92% of Java online submissions for Min Stack.
 * Memory: 49 MB, less than 14.79% of Java online submissions for Min Stack.
 *
 */
public class EasyMinStack {

    public EasyMinStack() {
    }

    // keep 2 stack, 1 for data, 1 for min
    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int val) {
        dataStack.push(val);
        try {
            minStack.push( Math.min(val, minStack.peek()) );
        } catch(EmptyStackException ex) {
            minStack.push(val);
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
