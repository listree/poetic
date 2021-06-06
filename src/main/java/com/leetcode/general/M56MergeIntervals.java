package com.leetcode.general;

import java.util.*;

/**
 * Question: 56. Merge Intervals
 * Description: https://leetcode.com/problems/merge-intervals/
 */

public class M56MergeIntervals {

    public final static void main(String[] args) {

        M56MergeIntervals quickTesters = new M56MergeIntervals();

        int[][] intervals = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] merged = quickTesters.merge(intervals);

        System.out.println(merged.length);
        for(int i = 0; i < merged.length; i++) {
            System.out.println(merged[i][0] + "-" + merged[i][1]);
        }
    }

    /*
    Runtime: 64 ms, faster than 5.37% of Java online submissions for Merge Intervals.
    Memory Usage: 41.4 MB, less than 84.68% of Java online submissions for Merge Intervals.
     */
    public int[][] merge(int[][] intervals) {

        List<int[]> sorted = new ArrayList<int[]>();
        sorted.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] x = intervals[i];
            for(int j = 0 ; j < sorted.size(); j++) {
                if( sorted.get(j)[0] > x[0] ) {
                    sorted.add(j, x);
                    break;
                }
            }
            if( sorted.size() <= i)
                sorted.add(x);
        }

        List<int[]> merger = new ArrayList<int[]>();
        int[] worker = sorted.get(0);

        for(int i = 1; i < sorted.size(); i++) {
            if( worker[1] >= sorted.get(i)[0] ) {
                if( worker[1] < sorted.get(i)[1])
                    worker[1] = sorted.get(i)[1];
            }
            else {
                merger.add(worker);
                worker = sorted.get(i);
            }
        }
        merger.add(worker);

        int[][] ret = new int[merger.size()][2];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = merger.get(i);
        }
        return ret;
    }
}
