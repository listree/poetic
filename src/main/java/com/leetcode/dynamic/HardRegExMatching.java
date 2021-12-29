package com.leetcode.dynamic;

/**
 * 10. Regular Expression Matching (Hard)
 * https://leetcode.com/problems/regular-expression-matching/
 * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * Runtime: 156 ms, faster than 12.95% of Java online submissions for Regular Expression Matching.
 * Memory: 117.3 MB, less than 12.58% of Java online submissions for Regular Expression Matching.
 */
public class HardRegExMatching {
    public boolean isMatch(String s, String p) {
 
        if(p.length() == 0)
            return s.length() == 0;
 
        //p's length 1 is special case    
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));    
 
        }else{
            int len = s.length();
 
            int i = -1; 
            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatch(s.substring(i+1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        } 
    }
}
