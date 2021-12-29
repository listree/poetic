package com.leetcode.amazon;

import java.util.*;

/** Leet: 1268. Search Suggestions System (Medium)
 * Link: https://leetcode.com/problems/search-suggestions-system/
 * Given an array of strings products and a string searchWord. We want to design a system that suggests at most three
 * product names from products after each character of searchWord is typed. Suggested products should have common prefix
 * with the searchWord. If there are more than 3 products with a common prefix return 3 lexicographically minimums products.
 * Return list of lists of the suggested products after each character of searchWord is typed.
 * Runtime: 26 ms, faster than 70.03% of Java online submissions for Search Suggestions System.
 * Memory Usage: 42.5 MB, less than 85.68% of Java online submissions for Search Suggestions System.
 */

public class MediumSearchTips {

    public final static void main(String[] args) {

        MediumSearchTips tester = new MediumSearchTips();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        List<List<String>> list = tester.suggestedProducts(products, searchWord);
        for( List<String> sublist: list) {
            for( String str : sublist )
                System.out.print(str + "-");
            System.out.println();
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for( String product: products) {
            int length = Math.min(product.length(), searchWord.length());
            for(int i = 0; i < length; i++) {
                if (product.charAt(i) != searchWord.charAt(i)) break;
                String prefix = searchWord.substring(0, i);
                PriorityQueue<String> queue = map.get(prefix);
                if( queue == null ) {
                    queue = new PriorityQueue<String>();
                    map.put(prefix, queue);
                }
                queue.add(product);
            }
        } // end of product for

        List<List<String>> list = new ArrayList<List<String>>();
        for(int i = 0; i < searchWord.length(); i++) {
            Queue queue = map.get(searchWord.substring(0, i));
            List<String> strings = new ArrayList<String>();
            int count = 0;
            if( queue != null ) {
                while (!queue.isEmpty() && count++ < 3) {
                    strings.add((String) queue.poll());
                }
            }
            list.add(strings);
        }
        return list;
    }

}
