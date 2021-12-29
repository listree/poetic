package com.leetcode.amazon;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-window-substring/
 * 76. Minimum Window Substring (Hard)
 * Given two strings s and t of lengths m and n respectively,
 * return the minimum window substring of s such that every
 * character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * The test cases will be generated such that the answer is unique.
 * A substring is a contiguous sequence of characters within the string.
 * Poem Runtime: 20 ms, faster than 25.04% of Java online submissions for Minimum Window Substring.
 * Memory Usage: 39.5 MB, less than 57.55% of Java online submissions for Minimum Window Substring.
 */
public class HardMinSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";
        HardMinSubstring tester = new HardMinSubstring();
        System.out.println("Check Answer:" + tester.minWindow(s,t));
    }

    public String minWindow(String s, String t) {

        //Construct Target Dictionary
        HashMap<Character, Integer> targetDict = new HashMap<>();
        for(Character c : t.toCharArray()){
            targetDict.put(c, targetDict.getOrDefault(c, 0) + 1);
        }

        int matchCount = 0;
        int size = Integer.MAX_VALUE;
        String window = "";
        HashMap<Character, Integer> workingMap = new HashMap<>();

        int i =  0;
        for(int j = 0; j < s.length(); j++) {
            char ic = s.charAt(j);
            if(!targetDict.containsKey(ic)){
                continue;
            }

            //if c is a target character, and totalMatch < targetSize, increase the totalMatch
            int count = workingMap.getOrDefault(ic, 0);
            if(count < targetDict.get(ic)){
                matchCount++;
            }

            workingMap.put(ic, count+1);

            //when totalMatch reaches, trim from left until no more chars can be trimmed.
            if(matchCount == t.length()){
                while(!targetDict.containsKey(s.charAt(i)) || workingMap.get(s.charAt(i)) > targetDict.get(s.charAt(i))) {
                    char pc = s.charAt(i);
                    if(targetDict.containsKey(pc) && workingMap.get(pc) > targetDict.get(pc)){
                        workingMap.put(pc, workingMap.get(pc) - 1);
                    }
                    i++;
                } // end of while

                if(size > j - i + 1 ){
                    size = j - i + 1;
                    window = s.substring(i, j + 1);
                }
            }
        }

        return window;
    }

}

