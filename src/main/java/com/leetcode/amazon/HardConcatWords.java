package com.leetcode.amazon;

import java.util.*;

/**
 * https://leetcode.com/problems/concatenated-words/
 * 472. Concatenated Words (Hard)
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 * Poem Runtime: 1641 ms, faster than 41.86% of Java online submissions for Concatenated Words.
 * Memory Usage: 145.8 MB, less than 45.08% of Java online submissions for Concatenated Words.
 */
public class HardConcatWords {

    public final static void main(String[] args) {
        HardConcatWords tester = new HardConcatWords();

        //String[] words = {""};
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};

        //Output: ["catsdogcats", "dogcatsdog", "ratcatdogcat"]
        List<String> list = tester.findAllConcatenatedWordsInADict(words);
        System.out.println(list);

    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<String>();
        for(String word: words) {
            set.add(word);
        }

        for(String word: words) {
            set.remove(word);
            if(checkWord(set, word)) {
                list.add(word);
            }
            set.add(word);
        }

        return list;
    }

    private boolean checkWord(HashSet<String> set, String word) {

        int n = word.length();
        if( n == 0)
            return false;

        boolean[] valid = new boolean[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i+1; j++) {
                if( (j == 0  || valid[j-1]) && set.contains(word.substring(j, i+1)) ) {
                    valid[i] = true;
                }
            }
        }

        return valid[n-1];
    }
}