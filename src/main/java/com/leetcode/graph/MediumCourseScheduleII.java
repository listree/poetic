package com.leetcode.graph;
import java.util.*;

/**
 * Question: 210. Course Schedule II (Medium)
 * Description: https://leetcode.com/problems/course-schedule-ii/
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed
 * as a pair: [0,1] Given the total number of courses and a list of prerequisite pairs, return the ordering of courses
 * you should take to finish all courses. There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * Note: The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how
 * a graph is represented. You may assume that there are no duplicate edges in the input prerequisites.
 * Poet Runtime: 9 ms, faster than 59.51% of Java online submissions for Course Schedule II.
 * Poem Memory: 48.9 MB, less than 52.69% of Java online submissions for Course Schedule II.
 */

public class MediumCourseScheduleII {

    public final static void main (String[] args) {

        MediumCourseScheduleII tester = new MediumCourseScheduleII();

        int[][] prerequisites = {{0, 1}, {1, 0}};
        int[] order = tester.findOrder(2, prerequisites);
        System.out.println("order size: " + order.length);  // Output: [1,0]
        for (int o : order) System.out.print(o + "-");
        System.out.println();  // Output: []

        int[][] prerequisites2 = {{1,0},{2,0},{3,1},{3,2}};
        int[] order2 = tester.findOrder(4, prerequisites2);
        System.out.println("order size: " + order2.length);
        for (int o : order2) System.out.print(o + "-");
        System.out.println();  // Output: [0,1,2,3], etc...

    }
    enum VisitStatus { NEVER, VISITING, VISITED }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<Integer>[] depends = new List[numCourses];
        for (int i = 0; i < numCourses; ++i)
            depends[i] = new ArrayList<>();
        for (int[] p : prerequisites)
            depends[p[1]].add(p[0]);

        ArrayList<Integer> orders = new ArrayList<>();
        VisitStatus[] status = new VisitStatus[numCourses];
        for (int i = 0; i < numCourses; ++i)
            if (checkCycle(i, depends, status, orders))
                return new int[] {};

        return orders.stream().mapToInt(i -> i).toArray();

    }

    private boolean checkCycle(int u, List<Integer>[] depends, VisitStatus[] state, List<Integer> orders) {

        if (state[u] == VisitStatus.VISITING)
            return true;

        if (state[u] == VisitStatus.VISITED)
            return false;

        state[u] = VisitStatus.VISITING;
        for (int v : depends[u])
            if (checkCycle(v, depends, state, orders))
                return true;

        state[u] = VisitStatus.VISITED;
        orders.add(0, u);
        return false;
    }

}
