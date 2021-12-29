package com.leetcode.design;

import java.util.*;

/**
 * https://leetcode.com/problems/lru-cache/
 * 146. LRU Cache (Medium)
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * Implement the LRUCache class:
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 * Runtime: 50 ms, faster than 44.65% of Java online submissions for LRU Cache.
 * Memory: 118.3 MB, less than 23.56% of Java online submissions for LRU Cache.
 */
public class MediumLRUCache {

    public static void main(String[] args) {
        MediumLRUCache tester = new MediumLRUCache(2);
        tester.put(1, 1);
        tester.put(2, 2);
        System.out.println("Check: " + ( 1 == tester.get(1))); //1
        tester.put(3, 3);
        System.out.println("Check: " + ( -1 == tester.get(2))); // -1
        tester.put(4, 4);
        System.out.println("Check: " + (-1 == tester.get(1))); // -1
        System.out.println("Check: " +  ( 3 == tester.get(3))); // 3
        System.out.println("Check: " + (4 == tester.get(4))); // 4
    }

    private int capacity;
    private LinkedHashMap<Integer, Integer> queueMap;

    public MediumLRUCache(int capacity) {
        this.capacity = capacity;
        this.queueMap = new LinkedHashMap<>();
    }

    public int get(int key) {

        //Get key then remove key from any where in cache
        int value = -1;
        if(  queueMap.containsKey(key) ) {
            value = queueMap.get(key);
            queueMap.remove(key);
        }

        //Put key back on tail of cache to maintain its most recency
        if(value != -1) {
            queueMap.put(key, value);
        }

        return value;
    }

    public void put(int key, int value) {

        //remove if exists
        if(queueMap.containsKey(key)) {
            queueMap.remove(key);
        } else {
            // check capacity if overflow, remove head
            if(capacity <= queueMap.size()) {
                int firstItemKey = queueMap.keySet().iterator().next();
                queueMap.remove(firstItemKey);
            }
        }
        // Put back
        queueMap.put(key, value);
    }

}
