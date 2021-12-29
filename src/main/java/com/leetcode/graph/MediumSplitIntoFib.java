package com.leetcode.graph;

import java.util.*;

/** https://leetcode.com/problems/split-array-into-fibonacci-sequence/
 * 842. Split Array into Fibonacci Sequence (Medium)
 * You are given a string of digits num, such as "123456579". We can split it into a Fibonacci-like sequence [123, 456, 579].
 * Formally, a Fibonacci-like sequence is a list f of non-negative integers such that:
 * 0 <= f[i] < 2^31, (that is, each integer fits in a 32-bit signed integer type),
 * f.length >= 3, and f[i] + f[i + 1] == f[i + 2] for all 0 <= i < f.length - 2.
 * Note that when splitting the string into pieces, each piece must not have extra leading zeroes, except if the piece
 * is the number 0 itself. Return any Fibonacci-like sequence split from num, or return [] if it cannot be done.
 * Runtime: 470 ms, faster than 5.54% of Java online submissions for Split Array into Fibonacci Sequence.
 * Memory: 114.6 MB, less than 5.19% of Java online submissions for Split Array into Fibonacci Sequence.
 */
public class MediumSplitIntoFib {

    public final static void main(String[] args) {
        MediumSplitIntoFib tester = new MediumSplitIntoFib();
        List<Integer> list1 = tester.splitIntoFibonacci("123456579");
        for( Integer i: list1) System.out.println(i);
        List<Integer> list2 = tester.splitIntoFibonacci("214748364721474836422147483641");
        for( Integer i: list2) System.out.println(i);
    }

    public List<Integer> splitIntoFibonacci(String num) {

        if( num.length() < 3)
            return new ArrayList<>();

        //index:  0    3   6
        //num:    123  456 789

        int imax = (num.charAt(0) == '0') ? 1 : (num.length() - 2);
        for(int i = 1;  i <= imax; i++) { // num starts with '0'

            int jmax = (num.charAt(i) == '0') ? (i+1)  : (num.length() - 1);
            for( int j = i + 1; j <= jmax; j++ ) {

                try {
                    //Check [0, i), [i, j), [j, n) is in fibonacci-style
                    int n1 = Integer.parseInt(num.substring(0, i));
                    int n2 = Integer.parseInt(num.substring(i, j));
                    int n3 = n1 + n2;

                    String n3AsString = ((Integer) n3).toString();
                    List<Integer> fibList = new ArrayList<Integer>();
                    fibList.add(n1);
                    fibList.add(n2);

                    int k = j;
                    while (k < num.length() && num.substring(k).startsWith(n3AsString)) {
                        k = k + n3AsString.length();
                        fibList.add(n3);
                        n1 = n2;
                        n2 = n3;
                        n3 = n1 + n2;
                        n3AsString = ((Integer) n3).toString();
                    }

                    if (k == num.length()) {
                        return fibList;
                    }
                } catch(NumberFormatException ex) {
                    //ignore
                    //ex.printStackTrace();
                }
            }

        }

        return new ArrayList<>();
    }


}
