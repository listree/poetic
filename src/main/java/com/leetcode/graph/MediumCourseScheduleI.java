package com.leetcode.graph;

import java.util.*;

/** Question: 207. Course Schedule (Medium)
 *  Description: https://leetcode.com/problems/course-schedule/
 *  There are a total of n courses you have to take, labeled from 0 to n-1.
 *  Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *  Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 *  Runtime: 8 ms, faster than 34.39% of Java online submissions for Course Schedule.
 *  Memory: 47.3 MB, less than 7.93% of Java online submissions for Course Schedule.
 */
public class MediumCourseScheduleI {

    public final static void main (String[] args) {

        MediumCourseScheduleI tester = new MediumCourseScheduleI();

        int[][] prerequisites1 = { { 1, 0 } };
        boolean canFinish1 = tester.canFinish(2, prerequisites1);
        System.out.println("Example 1(true):" + canFinish1);

        int[][] prerequisites2 = { { 1, 0 }, { 0, 1 } };
        boolean canFinish2 = tester.canFinish(2, prerequisites2);
        System.out.println("Example 2(false):"+ canFinish2);

        int[][] prerequisites3 = { { 0, 1 }, { 0, 2 }, {1, 3}, {1, 3} };
        boolean canFinish3 = tester.canFinish(4, prerequisites3);
        System.out.println("Example3(true):"+ canFinish3);

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] edges = new List[numCourses];
        for(int i = 0; i < numCourses; i++) {
            edges[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i < prerequisites.length; i++) {
            edges[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        boolean[] checked = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if( !checked[i] ) {
                boolean markers[] = new boolean[numCourses];
                if (dfsCycle(i, markers, edges, checked))
                    return false;
            }
        }

        return true;

    }

    private boolean dfsCycle(int v, boolean markers[], List<Integer>[] edges, boolean[] checked) {

        if( checked[v] )
            return false;

        markers[v] = true;
        for( int u : edges[v] ) {
            if (markers[u])
                return true;
            else if (dfsCycle(u, markers, edges, checked))
                return true;
            else
                continue;
        }

        markers[v] = false;
        checked[v] = true;
        return false;
    }


}
