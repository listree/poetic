package com.leetcode.amazon;

import java.util.*;

/**
 * Leet: 763. Partition Labels (Medium)
 * Link: https://leetcode.com/problems/partition-labels/
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears
 * in at most one part. Note that the partition is done so that after concatenating all the parts in order,
 * the resultant string should be s. Return a list of integers representing the size of these parts.
 * Poem Runtime: 16 ms, faster than 11.26% of Java online submissions for Partition Labels.
 * Memory Usage: 39.5 MB, less than 25.39% of Java online submissions for Partition Labels.
 */
public class MediumPartitionLabels {

    public static final void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        MediumPartitionLabels tester = new MediumPartitionLabels();
        // Output: [9,7,8] The partition is "ababcbaca", "defegde", "hijhklij".
        System.out.println(tester.partitionLabels(s));

        s = "caedbdedda"; //[1,9]
        System.out.println(tester.partitionLabels(s));
    }

    public List<Integer> partitionLabels(String s) {

        Map<Character, Integer> starts = new HashMap<>();
        Map<Character, Integer> ends = new HashMap<>();

        for(int i =  0; i < s.length(); i++) {
            char c = s.charAt(i);
            if( starts.containsKey(c) ) {
               ends.put(c, i);
            } else {
                starts.put(c, i);
                ends.put(c, i);
            }
        }

        List<Integer> partition = new ArrayList<Integer>();
        int start = 0;
        int end = ends.get(s.charAt(start));

        for(int i =  0; i < s.length(); i++) {
            char c = s.charAt(i);
            if( i < end ) {
                end = Math.max(end, ends.get(c));
            } else { // i == end
                partition.add( ( i - start + 1) );
                if( i == (s.length() -1) )
                    break;
                start = i + 1;
                end = ends.get(s.charAt(start));
            }

        }

        return partition;
    }

}
