package com.leetcode.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/k-closest-points-to-origin/
 * 973. K Closest Points to Origin (Medium)
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k,
 * return the k closest points to the origin (0, 0).
 * The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
 * Runtime: 71 ms, faster than 24.43% of Java online submissions for K Closest Points to Origin.
 * Memory: 113.9 MB, less than 71.42% of Java online submissions for K Closest Points to Origin.
 */
public class MediumKClosestPoints {

    public int[][] kClosest(int[][] points, int k) {

        Comparator<int[]> comparator = new <int[]> PointComparator();
        PriorityQueue<int[]>  queue = new <int[]> PriorityQueue(k, comparator);
        for(int[] point: points) {
            if( queue.size() == k) {
                int[] peek = queue.peek();
                if( distance(point) < distance(peek) ) {
                    queue.poll();
                    queue.add(point);
                }
            } else {
                queue.add(point);
            }
        }

        int[][] topK = new int[queue.size()][];
        int i = 0 ;
        while( !queue.isEmpty() ) {
            topK[i++] = queue.poll();
        }

        return topK;
    }

    long distance(int[] s1) {
        return ((long) s1[0]) *  ((long) s1[0]) + ((long) s1[1]) * ((long) s1[1]);
    }

    class PointComparator implements Comparator<int[]>{
        public int compare(int[] s1, int[] s2) {
            return (int) (distance(s2) - distance(s1)) ;
        }
    }

}
