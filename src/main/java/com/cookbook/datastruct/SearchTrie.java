package com.cookbook.datastruct;

import java.util.*;

/**
 * Operations on Trie: insert, search, startsWith, etc...
 */
public class SearchTrie {

    private TrieNode root;

    public SearchTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        return startsWith(word, true);
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String word, boolean checkEnd) {
        TrieNode p = root;
        for(int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (p.children[index] == null)
                return false;
            p = p.children[index];
        } // end of for

        if( checkEnd )
           return (p!= null && p.isEnd );
        else
            return p!= null;

    }

    public Set retrieveAll() {
        return retrieveSubTrie(root, "");
    }

    public Set retrieveSubTrie(TrieNode subtrie, String prefix) {

        Set set = new HashSet<>();
        if( subtrie.isEnd )
            set.add(prefix);

        for(int i = 0; i < 26; i++) {
            if (subtrie.children[i] != null) {
                char c = (char) ('a' + i);
                set.addAll(retrieveSubTrie(subtrie.children[i], prefix + c));
            }
        }
        return set;
    }

    /**
     * TrieNode only stores 26 characters of lowercase character
     */
    public class TrieNode {

        TrieNode[] children; // can convert to map for large character set, e.g. unicode
        public boolean isEnd;

        public TrieNode() {
            this.children = new TrieNode[26];
        }

    }

}