package com.leetcode.general;

/**
 * Question: 5. Longest Palindromic Substring
 * Description : https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
*/
public class M5LongestPalindrome {

    public static void main(String[] args) {
        M5LongestPalindrome tester = new M5LongestPalindrome();
        //    Example 1:
        //    Input: "babad"
        //    Output: "bab", "aba" is also a valid answer.
        System.out.println( tester.longestPalindrome("babad") );

        //  Example 2:
        //  Input: "cbbd"
        //  Output: "bb"
        System.out.println( tester.longestPalindrome("cbbd") );
    }

    /*
    Runtime: 24 ms, faster than 77.37% of Java online submissions for Longest Palindromic Substring.
    Memory Usage: 39 MB, less than 82.28% of Java online submissions for Longest Palindromic Substring.
    */
    public String longestPalindrome(String s) {

        int maxSize = 0;
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            int size = palindromeOddSize(s, i);
            if( size > maxSize ) {
                maxSize = size;
                index = i;
            }
        }

        String string1 = index > -1 ? s.substring(index - maxSize/2, index + maxSize/2 + 1) : "";

        int maxSize2 = 0;
        int index2 = -1;
        for (int i = 1; i < s.length(); i++) {
            int size = palindromeEvenSize(s, i);
            if( size > maxSize2 ) {
                maxSize2 = size;
                index2 = i;
            }
        }

        String string2 = (index2 > 0) ? s.substring(index2 - maxSize2/2, index2 + maxSize2/2) : "";
        return (string1.length() > string2.length()) ? string1 : string2;


    }


    private int palindromeOddSize(String s, int i) {

        int half = 1;
        int left = i - half;
        int right = i + half;

        while( left > -1 && right < s.length() ) {
            if( s.charAt(left) == s.charAt(right) ) {
                half++;
                left--;
                right++;
                continue;
            } else {
                break;
            }
        }
        return 2 * half - 1;
    }

    private int palindromeEvenSize(String s, int i) {

        int half = 0;
        int left = i - half - 1;
        int right = i + half;

        while( left > -1 && right < s.length() ) {
            if( s.charAt(left) == s.charAt(right) ) {
                half++;
                left--;
                right++;
                continue;
            } else {
                break;
            }
        }
        return 2 * half;
    }

}