package com.leetcode.graph;
import java.util.*;

/**
 * Question: 210. Course Schedule II
 * Description: https://leetcode.com/problems/course-schedule-ii/
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * Note:The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */

public class M218CourseSchedule2 {

    public final static void main (String[] args) {

        M218CourseSchedule2 tester = new M218CourseSchedule2();
        {
            System.out.println("Example 1 Output: [0,1]");
            int[][] prerequisites = {{1, 0}};
            int[] order = tester.findOrder(2, prerequisites);
            for (int course : order) System.out.print("-" + course);
            System.out.println();
        }
        {
            System.out.println("Example 2 Output: [0,1,2,3] or [0,2,1,3]");
            int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
            int[] order = tester.findOrder(4, prerequisites);
            for (int course : order) System.out.print("-" + course);
            System.out.println();
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for (int i = 0; i < numCourses; i++)
            map.put(i, new HashSet<Integer>());

        for (int[] prerequisite : prerequisites) {
            map.get(prerequisite[1]).add(prerequisite[0]);
        }

        int[] order = new int[numCourses];
        int index = 0;

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
                numCourses,
                (x, y) -> map.get(y).size() - map.get(x).size()
        );

        for (int i = 0; i < numCourses; i++) {
            queue.add(i);
        }
        while( !queue.isEmpty() ) {
            int x = queue.poll();
            //TODO: if( !map.get(x).isEmpty() )
            //    return null;

            order[index++] = x;
            // TODO: reduce each dependency by 1
            continue;
        }

        return order;
    }


}
