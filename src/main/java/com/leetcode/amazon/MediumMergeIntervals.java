package com.leetcode.amazon;

import java.util.*;

/**
 * Leet: 56. Merge Intervals (Medium)
 * Link: https://leetcode.com/problems/merge-intervals/
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 * Runtime: 5 ms, faster than 95.82% of Java online submissions for Merge Intervals.
 * Memory Usage: 41.8 MB, less than 52.79% of Java online submissions for Merge Intervals.
*/

public class MediumMergeIntervals {

    public static void main(String[] args) {
        MediumMergeIntervals tester = new MediumMergeIntervals();
        int[][] example1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = tester.merge(example1);
        for (int i = 0; i < merged.length; i++)
            System.out.print(merged[i][0] + "-" + merged[i][1] +",");
        System.out.println();

        int[][] example2 =  {{1,4}, {4,5}};
        int[][] merged2 = tester.merge(example2);
        for (int i = 0; i < merged2.length; i++)
            System.out.print(merged2[i][0] + "-" + merged2[i][1] + ",");
        System.out.println();

        int[][] example3 =  {{1,4}, {0,4}};
        int[][] merged3 = tester.merge(example3);
        for (int i = 0; i < merged3.length; i++)
            System.out.println(merged3[i][0] + "-" + merged3[i][1] + ",");
        System.out.println();

    }


   public int[][] merge(int[][] intervals) {

       // initial map sorted by start point
       // skip those inside others
       TreeMap<Integer, Integer> sortedByStart = new TreeMap<Integer, Integer>();
       for(int i = 0 ; i < intervals.length; i++) {
           int istart = intervals[i][0];
           if( !sortedByStart.containsKey(istart) ) {
               sortedByStart.put(istart, i);
           } else {
               int j = sortedByStart.get(istart);
               int jend = intervals[j][1];
               int iend = intervals[i][1];
               if( jend < iend ) {
                   sortedByStart.put(istart, i);
               } // otherwise, skip i
           }
       }

       //merge when overlap found
       int[] current = null;
       Set<int[]> mergedSet = new HashSet<int[]>();
       for( Integer start : sortedByStart.keySet() ) {
           if( current == null ) {
               int index = sortedByStart.get(start);
               current = intervals[index];
           } else {
               int index = sortedByStart.get(start);
               int[] next = intervals[index];
               if( next[0] <= current[1] ) { //overlap
                   current[1]= Math.max(current[1], next[1]);
               } else {
                   mergedSet.add(current);
                   current = next;
               }
           }
       }

       if( current != null ) //last one
           mergedSet.add(current);

       int[][] merged = new int[mergedSet.size()][];
       int i = 0;
       for( int[] interval : mergedSet) {
           merged[i++] = interval;
       }

       return merged;

   }

}

