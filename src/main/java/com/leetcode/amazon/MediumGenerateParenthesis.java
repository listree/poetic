package com.leetcode.amazon;

import java.util.*;

/**
 * https://leetcode.com/problems/generate-parentheses/
 * 22. Generate Parentheses (Medium)
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Runtime: 17 ms, faster than 7.86% of Java online submissions for Generate Parentheses.
 * Memory: 43.7 MB, less than 49.34% of Java online submissions for Generate Parentheses.
 */
public class MediumGenerateParenthesis {

    public final static void main(String[] args) {
        MediumGenerateParenthesis me = new MediumGenerateParenthesis();
        System.out.println( me.generateParenthesis(3));

    }

    public List<String> generateParenthesis(int n) {
        Set<String> set = genSet(n);
        List<String> list = new ArrayList<String>();
        for (String x : set)
            list.add(x);
        return list;
    }

    HashMap<Integer, Set<String>> map = new HashMap<Integer,Set<String>>();

    private Set<String> genSet(int n) {

        if( map.containsKey(n) ) {
            return map.get(n);
        }

        Set<String> set = new HashSet<String>();
        if( n < 1) {
            set.add("");
            map.put(n, set);
            return set;
        }

        if( n == 1) {
            set.add("()");
            map.put(n, set);
            return set;
        }

        for(int i = 0 ; i < n; i++) {
            //System.out.println( n + " - " + i + " - " + (n-i-1));

            Set<String> xSet = genSet(i);
            Set<String> ySet = genSet(n-i-1);

            for( String x: xSet)
                for( String y: ySet) {
                    set.add("(" + x + ")" + y);
                }
        }

        map.put(n, set);
        return set;
    }

}
