package com.leetcode.design;

import java.util.*;

/**
 * https://leetcode.com/problems/design-search-autocomplete-system/
 * 642. Design Search Autocomplete System (Hard)
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with
 * a special character '#').
 * You are given a string array sentences and an integer array times both of length n where sentences[i] is a previously
 * typed sentence and times[i] is the corresponding number of times the sentence was typed. For each input character
 * except '#', return the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed.
 * Here are the specific rules:
 * The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before.
 * The returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences
 * have the same hot degree, use ASCII-code order (smaller one appears first).
 * If less than 3 hot sentences exist, return as many as you can.
 * When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.
 * Implement the AutocompleteSystem class:
 *
 * AutocompleteSystem(String[] sentences, int[] times) Initializes the object with the sentences and times arrays.
 * List<String> input(char c) This indicates that the user typed the character c.
 * Returns an empty array [] if c == '#' and stores the inputted sentence in the system.
 * Returns the top 3 historical hot sentences that have the same prefix as the part of the sentence already typed. If
 * there are fewer than 3 matches, return them all.
 */
public class AutocompleteSystem {

    public final static void main(String[] args) {
        String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
        int[] times = {5, 3, 2, 2};
        AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
        // return ["i love you", "island", "i love leetcode"]. There are four sentences that have prefix "i".
        // Among them, "ironman" and "i love leetcode" have same hot degree. Since ' ' has ASCII code 32 and 'r' has
        // ASCII code 114, "i love leetcode" should be in front of "ironman". Also we only need to output top 3 hot
        // sentences, so "ironman" will be ignored.
        System.out.println("input i: " + obj.input('i')); // ["i love you", "island", "i love leetcode"].
        // return ["i love you", "i love leetcode"]. There are only two sentences that have prefix "i ".
        System.out.println("input space: " + obj.input(' '));
        // return []. There are no sentences that have prefix "i a".
        System.out.println("input a: " + obj.input('a')); // return []. The user finished the input
        // sentence in system. And the following input will be counted as a new search.
        System.out.println("input #: " + obj.input('#')); // return []

    }

    public class Node { // TrieNode with extra bits

        public String myString;
        public int myTime;

        public Node[] myChildren = new Node[27]; // support 26 lowercase ascii and space
        public List<Node> myTop3 = new ArrayList<Node>();

        public void update(Node leaf) {
            if (!myTop3.contains(leaf)) {
                myTop3.add(leaf);
                if (myTop3.size() > 3) {
                    Collections.sort(myTop3, nodeComparator);
                    myTop3.remove(myTop3.size() - 1);
                }
            }
        }
    }

    NodeComparator nodeComparator = new NodeComparator();

    public class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node y1, Node y2) {
            int x = y2.myTime - y1.myTime;
            if (x != 0)
                return x;
            else
                return y1.myString.compareTo(y2.myString);
        }
    }

    Node root = new Node();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < times.length; i++) {
            insertNode(sentences[i], times[i]);
        }
    }

    private void insertNode(String str, int time) {
        Node node = root;
        for (Character c : str.toCharArray()) {
            int i = (c == ' ') ? 26 : (c - 'a');
            if (node.myChildren[i] == null) {
                node.myChildren[i] = new Node();
            }
            node = node.myChildren[i];
        }

        // at end, node is leaf
        Node leaf = node;
        leaf.myString = str;
        leaf.myTime += time;

        // revisit update top3
        node = root;
        for (Character c : str.toCharArray()) {
            int i = (c == ' ') ? 26 : (c - 'a');
            node.myChildren[i].update(leaf);
            node = node.myChildren[i];
        }

    }

    Node searchNode = root;
    String searchString = "";

    public List<String> input(char c) {
        List<String> top3 = new ArrayList<String>();
        int i = (c == ' ') ? 26 : (c - 'a');

        if (i < 0 || i > 26) { // restart search
            searchNode = root;
            insertNode(searchString, 1);
            searchString = "";
            return top3;
        }

        searchString += c;

        if (searchNode.myChildren[i] == null)
            return top3;

        Collections.sort(searchNode.myChildren[i].myTop3, nodeComparator);
        for (Node node : searchNode.myChildren[i].myTop3)
            top3.add(node.myString);

        searchNode = searchNode.myChildren[i];
        return top3;
    }

}