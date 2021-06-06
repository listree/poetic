package com.leetcode.general;

import java.util.*;

/**
 * Question: 146. LRU Cache
 * Description: https://leetcode.com/problems/lru-cache/
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class M146LRUCache {

    public static void main(String[] args) {
        /* Example 1:
        Input:  ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
                [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        Output: [null, null, null, 1, null, -1, null, -1, 3, 4]
        */
        LRUCache tester = new LRUCache(2);
        tester.put(1, 1);
        tester.put(2, 2);
        System.out.println("get(1)= 1: " + tester.get(1)); //1
        tester.put(3, 3);
        System.out.println("get(2)=-1: " + tester.get(2)); // -1
        tester.put(4, 4);
        System.out.println("get(1)=-1: " + tester.get(1)); // -1
        System.out.println("get(1)= 3: " + tester.get(3)); // 3
        System.out.println("get(1)= 4: " + tester.get(4)); // 4
    }

    /*
    Runtime: 50 ms, faster than 44.65% of Java online submissions for LRU Cache.
    Memory Usage: 118.3 MB, less than 23.56% of Java online submissions for LRU Cache.
     */
    public static class LRUCache {

        public int capacity;

        // https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html
        private LinkedHashMap<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new LinkedHashMap<>();
        }

        public int get(int key) {
            //remove first from the cache
            int value = map.get(key) != null ? map.remove(key) : -1;

            if(value != -1) {
                //put back
                map.put(key, value);
            }

            return value;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                //remove, then put back (this will affect order)
                map.remove(key);
            } else {
                if(capacity <= map.size()) {
                    //remove first item
                    int firstItemKey = map.entrySet().iterator().next().getKey();
                    map.remove(firstItemKey);
                }
            }
            map.put(key, value);
        }
    }

}
