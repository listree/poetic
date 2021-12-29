package com.leetcode.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * 126. Word Ladder II (Hard)
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
 * beginWord -> s1 -> s2 -> ... -> sk such that: Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList. sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences
 * from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list
 * of the words [beginWord, s1, s2, ..., sk].
 * Runtime: 12 ms, faster than 80.77% of Java online submissions for Word Ladder II.
 * Memory: 42 MB, less than 99.91% of Java online submissions for Word Ladder II.
 */
public class HardWordLadderII {
    public final static void main(String[] args) {

        HardWordLadderII tester = new HardWordLadderII();

        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(words);
        // [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
        System.out.println(tester.findLadders("hit", "cog", wordList));

        String[] words2 =  {"hot","dog"};
        System.out.println(tester.findLadders("hot", "dog", Arrays.asList(words2)));

        String[] words3 =  {"hot","dog","dot"};
        System.out.println(tester.findLadders("hot", "dog", Arrays.asList(words3)));

    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        // BFS construct graphMap
        HashSet<String> wordSet = new HashSet<String>();
        for( String word: wordList) {
            wordSet.add(word);
        }

        HashMap<String, List<String>> graphMap = new HashMap<String, List<String>>();

        HashSet<String> layerSet = new HashSet<String>();
        layerSet.add(beginWord);
        wordSet.remove(beginWord);
        boolean found = false;

        while( !found && !wordSet.isEmpty() ) {
            for( String layerWord: layerSet) {
                if (graphMap.get(layerWord) == null)
                    graphMap.put(layerWord, new ArrayList<String>());

                for (String word : wordSet) {
                    if (diffByChar(layerWord, word)) {
                        graphMap.get(layerWord).add(word);
                    }
                }
            }

            HashSet<String> nextLayer = new HashSet<String>();
            for( String layerWord: layerSet) {
                for( String word: graphMap.get(layerWord) ) {
                    if( word.equals(endWord) ) found = true;
                    nextLayer.add(word);
                    //System.out.println("Removing..." + word + " " + found );
                    wordSet.remove(word);
                }
            }

            if( nextLayer.isEmpty() ) break;

            layerSet = nextLayer;
        }

        List<List<String>> result = new ArrayList<List<String>>();
        if( !found )
            return result;

        // DFS constructs result by graphMap
        List<String> list = new ArrayList<String>();
        list.add(beginWord);
        dfs(graphMap, beginWord, endWord, list, result);

        return result;
    }

    void dfs(HashMap<String, List<String>> graphMap, String currentWord, String endWord, List<String> list, List<List<String>> result ) {

        if( currentWord.equals(endWord) ) {
            result.add(new ArrayList(list));
            return;
        }

        if( !graphMap.containsKey(currentWord) )
            return;

        for(String word: graphMap.get(currentWord) ) {
            list.add(word);
            dfs(graphMap, word, endWord, list, result);
            list.remove(word);
        }

    }

    boolean diffByChar(String wordA, String wordB) {
        if( wordA.length() != wordB.length() )
            return false;

        int diff  = 0;
        for( int i = 0; i< wordA.length(); i++) {
            if( wordA.charAt(i) != wordB.charAt(i) ) {
                diff++;
            }
        }
        return (diff == 1);
    }

}
