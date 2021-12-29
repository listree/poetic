package com.leetcode.general;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * 5. Longest Palindromic Substring (Medium)
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Runtime: 28 ms, faster than 86.44% of Java online submissions for Longest Palindromic Substring.
 * Memory : 42.9 MB, less than 69.41% of Java online submissions for Longest Palindromic Substring.*/
public class MediumLongestPalindrome {

    public static void main(String[] args) {
        MediumLongestPalindrome tester = new MediumLongestPalindrome();
        //    Example 1:
        //    Input: "babad"
        //    Output: "bab", "aba" is also a valid answer.
        System.out.println( tester.longestPalindrome("babad") );

        //  Example 2:
        //  Input: "cbbd"
        //  Output: "bb"
        System.out.println( tester.longestPalindrome("cbbd") );
    }

    public String longestPalindrome(String s) {
        String maxString = "";
        for(int i = 0; i < s.length(); i++) {
            String oddString = palindromeByCenter(i,i, s);
            String evenString = palindromeByCenter(i,i+1, s);
            if(oddString.length() > maxString.length())
                maxString = oddString;
            if(evenString.length() > maxString.length())
                maxString = evenString;
        }
        return maxString;

    }

    private String palindromeByCenter(int i, int j, String string) {
        while( i > -1 && j < string.length() && string.charAt(i) == string.charAt(j) ) {
            i--;
            j++;
        }

        return string.substring(i+1, j);
    }

}