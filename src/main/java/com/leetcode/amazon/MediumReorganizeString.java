package com.leetcode.amazon;

import java.util.*;

/**
 * Leet: 767. Reorganize String (Medium)
 * Link: https://leetcode.com/problems/reorganize-string
 * Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
 * Runtime: 5 ms, faster than 40.50% of Java online submissions for Reorganize String.
 * Memory Usage: 39.1 MB, less than 19.82% of Java online submissions for Reorganize String.
 */
public class MediumReorganizeString {

    public static void main(String[] args) {
        MediumReorganizeString tester = new MediumReorganizeString();
        System.out.println("aab->" + tester.reorganizeString("aab"));
        System.out.println("aaab->" + tester.reorganizeString("aaab"));
        System.out.println("kkkkzrkatkwpkkkktrq->" + tester.reorganizeString("kkkkzrkatkwpkkkktrq"));
    }

    public String reorganizeString(String S) {

        Map<Character, Integer> counter = new HashMap<Character, Integer>();
        for( Character c: S.toCharArray() ) {
            if( counter.containsKey(c))
                counter.put(c, counter.get(c) + 1);
            else
                counter.put(c, 1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<Character>(counter.size(), (x,y) -> counter.get(y) - counter.get(x));
        for( Character c: counter.keySet() ) {
            queue.add(c);
        }

        String string = "";
        Character current = queue.poll();
        string += current;

        while( !queue.isEmpty() ) {
            Character next = queue.poll();
            string += next;
            if (counter.get(current) > 1) {
                counter.put(current, counter.get(current) - 1);
                queue.add(current);
            }
            current = next;
        }

        if( string.length() != S.length())
            return "";
        else
            return string;

    }

}
