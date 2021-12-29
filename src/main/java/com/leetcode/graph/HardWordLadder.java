package com.leetcode.graph;
import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder/
 * 127. Word Ladder (Hard)
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that:
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest
 * transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 * Poem Runtime: 1539 ms, faster than 6.23% of Java online submissions for Word Ladder.
 * Memory: 49.7 MB, less than 43.32% of Java online submissions for Word Ladder.
 */
public class HardWordLadder {

    public final static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        HardWordLadder tester = new HardWordLadder();
        int result = tester.ladderLength(beginWord, endWord, wordList);
        System.out.println(result);

    }

    private int wordDiff(String word1, String word2) {
        int count  = 0;
        for(int i = 0 ; i < word1.length(); i++) {
            if( word1.charAt(i) != word2.charAt(i) )
                count++;
        }
        return count;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if( !wordList.contains(endWord) )
            return 0;

        HashMap<String, List<String>> neighborMap = new HashMap<String, List<String>>(0);

        for( String currentWord: wordList) {
            if( ! neighborMap.containsKey(currentWord) ) {
                neighborMap.put(currentWord, new ArrayList<>());
            }
            for(String preWord: neighborMap.keySet() ) {
                if(wordDiff(preWord, currentWord) == 1) {
                    neighborMap.get(currentWord).add(preWord);
                    neighborMap.get(preWord).add(currentWord);
                }
            }
        } // end of for

        //BFS to find Shorted path from begin to end
        Set<String> visited = new HashSet<String>();
        Set<String> workingBatch = new HashSet<String>();
        int path = 1;
        for(String word: wordList) {
            if( wordDiff(beginWord, word) == 1) {
                workingBatch.add(word);
                visited.add(word);
            }
        }

        while(! workingBatch.isEmpty() ) {
            path++;
            Set<String> newBatch = new HashSet<String>();
            for(String batchWord: workingBatch) {
                if( batchWord.equals(endWord) ) {
                    return path;
                } else {
                    for (String neighbor : neighborMap.get(batchWord)) {
                        if (!visited.contains(neighbor)) { // ignore visited
                            newBatch.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                }
            }

            workingBatch = newBatch;
        }

        return 0;
    }

}
