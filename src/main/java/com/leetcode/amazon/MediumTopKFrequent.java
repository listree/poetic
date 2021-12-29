package com.leetcode.amazon;

import java.util.*;

/**
 * Leet: 347. Top K Frequent Elements (Medium)
 * Link: https://leetcode.com/problems/top-k-frequent-elements/
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 * Runtime: 8 ms, faster than 93.48% of Java online submissions for Top K Frequent Elements.
 * Memory Usage: 41.6 MB, less than 57.36% of Java online submissions for Top K Frequent Elements.
 */
public class MediumTopKFrequent {

    public final static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        MediumTopKFrequent tester = new MediumTopKFrequent();
        int[] top2 = tester.topKFrequent(nums, 2);
        System.out.println( top2[0] );
        System.out.println( top2[1] );


    }

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> counterMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            counterMap.put(nums[i], counterMap.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>
                ( (x, y) -> y.getValue() - x.getValue() );

        for( Map.Entry entry: counterMap.entrySet() ) {
            queue.add(entry);
        }

        int[] topK = new int[k];
        int j = 0 ;
        while( j < k ) {
            topK[j] = queue.poll().getKey();
            j++;
        }
        return topK;
    }
}
