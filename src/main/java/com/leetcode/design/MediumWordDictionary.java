package com.leetcode.design;

import com.leetcode.TrieNode;

/**
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 * 211. Design Add and Search Words Data Structure (Medium)
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * Implement the WordDictionary class: WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
 * word may contain dots '.' where dots can be matched with any letter.
 * Runtime: 1354 ms, faster than 37.88% of Java online submissions for Design Add and Search Words Data Structure.
 * Memory: 402.4 MB, less than 5.01% of Java online submissions for Design Add and Search Words Data Structure.
 */
public class MediumWordDictionary {

    public final static  void main(String[] args) {
        MediumWordDictionary tester = new MediumWordDictionary();
        tester.addWord("bad");
        tester.addWord("dad");
        tester.addWord("mad");

        System.out.println(tester.search("pad"));
        System.out.println(tester.search("bad"));
        System.out.println(tester.search(".ad"));
        System.out.println(tester.search("b.."));


    }

    TrieNode root = new TrieNode();
    public void addWord(String word) {
        TrieNode node = root;
        for(char c:  word.toCharArray()) {
            int pos = c - 'a';
            if( node.children[pos] == null )
                node.children[pos] = new TrieNode();
            node = node.children[pos];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode root) {
        // maybe need handling word or node null empty case

        char c = word.charAt(0);
        if( c != '.' ) {
            if( root.children[ c - 'a' ] == null )
                return false;

            if( word.length() == 1 )
                return root.children[ c - 'a' ].isWord;
            else
                return search(word.substring(1), root.children[ c - 'a']);

        } else {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] == null)
                    continue;

                if (word.length() == 1) {
                    if (root.children[i].isWord)
                        return true;
                } else {
                    if (search(word.substring(1), root.children[i]))
                        return true;
                }
            }
        }
        return false;
    }

}
