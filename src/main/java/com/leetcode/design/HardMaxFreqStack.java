package com.leetcode.design;
import java.util.*;

/**
 * https://leetcode.com/problems/maximum-frequency-stack/
 * 895. Maximum Frequency Stack (Hard)
 * Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
 * Implement the FreqStack class:
 * FreqStack() constructs an empty frequency stack.
 * void push(int val) pushes an integer val onto the top of the stack.
 * int pop() removes and returns the most frequent element in the stack.
 * If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
 * Runtime: 58 ms, faster than 33.07% of Java online submissions for Maximum Frequency Stack.
 * Memory: 75.8 MB, less than 16.62% of Java online submissions for Maximum Frequency Stack.
 */
public class HardMaxFreqStack {

    public final static void main(String[] args) {
        if(true) {
            HardMaxFreqStack freqStack = new HardMaxFreqStack();
            freqStack.push(5); // The stack is [5]
            freqStack.push(7); // The stack is [5,7]
            freqStack.push(5); // The stack is [5,7,5]
            freqStack.push(7); // The stack is [5,7,5,7]
            freqStack.push(4); // The stack is [5,7,5,7,4]
            freqStack.push(5); // The stack is [5,7,5,7,4,5]
            freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
            freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
            freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
            freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
        } else {
            HardMaxFreqStack freqStack = new HardMaxFreqStack();
            freqStack.push(5);
            freqStack.push(7);
            freqStack.push(5);
            freqStack.push(7);
            freqStack.push(4);
            freqStack.push(5);
            freqStack.pop();
            freqStack.pop();
            freqStack.pop();
            freqStack.pop();
        }
    }

    private int clock = 0;
    public class Element {
        int value;
        int count;
        int time;
        Element(int v, int c, int t) {
            value = v;
            count = c;
            time = t;
        }
        public String toString() {
            return "" + value + " " + count + " " + time;
        }
    }

    HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();
    PriorityQueue<Element> priorityQueue = new PriorityQueue<Element>(
        new Comparator<Element>() {
            public int compare(Element a, Element b) {
                return (b.count == a.count) ? (b.time - a.time) : b.count - a.count;
            }
        }
    );

    public void push(int val) {
        freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        Element element = new Element(val, freqMap.get(val), clock++);
        priorityQueue.add(element);
    }

    public int pop() {

        Element element = priorityQueue.poll();
        // System.out.println("pop:"+ element.value);
        // System.out.println("priorityQueue:"+ priorityQueue);
        freqMap.put(element.value, freqMap.get(element.value) - 1);
        return element.value;
    }

}
