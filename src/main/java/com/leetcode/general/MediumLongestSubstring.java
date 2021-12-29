package com.leetcode.general;

import java.util.*;

/**
 * Description: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 3. Longest Substring Without Repeating Characters (Medium)
 * Given a string s, find the length of the longest substring without repeating characters.
 * Runtime: 133 ms, faster than 8.82% of Java online submissions for Longest Substring Without Repeating Characters.
 * Memory: 46.7 MB, less than 5.13% of Java online submissions for Longest Substring Without Repeating Characters.
 */
public class MediumLongestSubstring {
    public final static void main(String[] args) {

        MediumLongestSubstring tester = new MediumLongestSubstring();
        // Example 1:
        // Input: "abcabcbb"
        // Output: 3
        // Explanation: The answer is "abc", with the length of 3.
        System.out.println(tester.lengthOfLongestSubstring("abcabcbb"));

        // Example 2: Input: "bbbbb"
        // Output: 1
        // Explanation: The answer is "b", with the length of 1.
        System.out.println(tester.lengthOfLongestSubstring("bbbbb"));

        // Example 3:
        // Input: "pwwkew"
        // Output: 3
        // Explanation: The answer is "wke", with the length of 3.
        // Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
        System.out.println(tester.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int maxLength = 0;
        int index = 0;
        while(index < s.length()) {
            char ch = s.charAt(index);
            if( map.containsKey(ch) ) {
                //Stop at 2nd ch position & Rewind right after 1st ch position
                //Recursively calculate length from rewind position to end
                String restString = s.substring(map.get(ch) + 1);
                int nextMaxLength = lengthOfLongestSubstring(restString);
                return nextMaxLength > maxLength ? nextMaxLength : maxLength;
            } else {
                map.put(ch, index);
                index++;
                maxLength++;
            }
        } // end of while
        return maxLength;
    }

}
