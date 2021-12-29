package com.leetcode.greedy;

import java.util.Arrays;

/**
 * 455. Assign Cookies (Easy)
 * https://leetcode.com/problems/assign-cookies/
 * Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.
 * Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with;
 * and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 * Poem Runtime: 8 ms, faster than 98.82% of Java online submissions for Assign Cookies.
 * Memory Usage: 39.9 MB, less than 100.00% of Java online submissions for Assign Cookies.
 */
public class AssignCookies {

    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int count  = 0;
        int i = 0; int j = 0;
        while ( i < g.length && j < s.length ) {
            if( g[i] <= s[j] ) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;

    }

}
