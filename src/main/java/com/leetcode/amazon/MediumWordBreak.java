package com.leetcode.amazon;

import java.util.*;

/**
 * Leet: 139. Word Break (Medium)
 * Link: https://leetcode.com/problems/word-break/
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Runtime: 3 ms, faster than 86.37% of Java online submissions for Word Break.
 * Memory Usage: 35.6 MB, less than 99.28% of Java online submissions for Word Break.
*/
public class MediumWordBreak {

    public final static void main(String[] args) {
        MediumWordBreak tester = new MediumWordBreak();
        System.out.println( tester.wordBreak("leetcode", Arrays.asList("leet", "code")) );
        System.out.println( tester.wordBreak("applepenapple", Arrays.asList("apple", "pen")) );
        System.out.println( tester.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")) );

    }

    // Use Dynamic Programming instead of recursive programming
    public boolean wordBreak(String s, List<String> wordDict) {

        // canBreak records if substring at i can be broke by wordDist
        boolean[] canBreak = new boolean[s.length()]; // default is false

        for( String word : wordDict ) {
            if( s.startsWith(word) )
                canBreak[word.length()-1] = true;
        }

        for(int i = 0; i < s.length(); i++ ) {
            if(!canBreak[i])
                continue;

            for( String word : wordDict ) {
                if( i + word.length() < s.length() ) {
                    if (s.substring(i + 1).startsWith(word)) {
                        canBreak[i + word.length()] = true;
                    }
                }
            }
        }

        return canBreak[s.length()-1];

    }

    /**
     * This recursive programming fails on the following test by RunOutTime Error:
     * "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
     ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
     */
    public static boolean wordBreakRecursively(String s, List<String> wordDict) {
        if( s.length()  == 0 )
            return true;

        for( String word: wordDict ) {
            if( s.startsWith(word) )
                if( wordBreakRecursively( s.substring(word.length()), wordDict ) )
                    return true;
        }
        return false;
    }

}
