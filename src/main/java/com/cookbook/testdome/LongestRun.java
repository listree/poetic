package com.cookbook.testdome;

/**
 * Created by poet on 7/19/16.
 */
public class LongestRun {


    public static int indexOfLongestRun(String str) {

        if( str == null || str.length() == 0) {
            return -1;
        }

        int pos = 0 ;
        int length =  1;
        int maxPos = 0;
        int maxLength  = 1;
        char c = str.charAt(0);

        for(int i = 1; i < str.length(); i++) {
            if( str.charAt(i) != c ) {
                if( length > maxLength ) {
                    maxPos = pos;
                    maxLength = length;
                }
                pos = i;
                length = 1;
                c = str.charAt(i);
            } else {
                length++;
            }
        }

        if( length > maxLength ) {
            maxPos = pos;
        }

        return maxPos;

    }

    public static void main(String[] args) {
//        System.out.println(indexOfLongestRun(null));
//        System.out.println(indexOfLongestRun(""));
//        System.out.println(indexOfLongestRun("a"));
//        System.out.println(indexOfLongestRun("abc"));
        System.out.println(indexOfLongestRun("abb"));
//        System.out.println(indexOfLongestRun("abbcccddddcccbbaaaa"));
    }
}