package com.leetcode.amazon;

/**
 * https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/
 * 1335. Minimum Difficulty of a Job Schedule (Hard)
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all
 * the jobs j where 0 <= j < i). You have to finish at least one task every day. The difficulty of a job schedule is
 * the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 * Poem Runtime: 5 ms, faster than 99.79% of Java online submissions for Minimum Difficulty of a Job Schedule.
 * Memory Usage: 42.7 MB, less than 5.35% of Java online submissions for Minimum Difficulty of a Job Schedule.
 */
public class HardJobDifficulty {

    public final static void main(String[] args) {

        HardJobDifficulty tester = new HardJobDifficulty();
        int[] jobDifficulty = {6, 5, 4, 3, 2, 1}; // 6 items
        int result = tester.minDifficulty(jobDifficulty, 2);
        System.out.println("result:" + result);

        int[] jobDifficulty2 = {11,111,22,222,33,333,44,444}; // 8 items
        int result2 = tester.minDifficulty(jobDifficulty2, 6);
        System.out.println("result2:" + result2); // 843

        // Time Limit Exceeded
        int[] jobDifficulty3 = {380,302,102,681,863,676,243,671,651,612,162,561,394,856,601,30,6,257,921,405,716,126,
                158,476,889,699,668,930,139,164,641,801,480,756,797,915,275,709,161,358,461,938,914,557,121,964,315};
        int result3 = tester.minDifficulty(jobDifficulty3, 10);
        System.out.println("result3:" + result3); //3807

    }

    public int minDifficulty(int[] jobDifficulty, int days) {
        if( days > jobDifficulty.length)
            return -1;

        return dynamic(jobDifficulty, days, jobDifficulty.length);
    }

    private int dynamic(int[] jobDifficulty, int days, int jobs) {
        int[][] dpMatrix = new int[days][jobs];

        int max = Integer.MIN_VALUE;
        for (int j = 0; j < jobs; j++) {
            max = Math.max(max, jobDifficulty[j]);
            dpMatrix[0][j] = max;
        }

        for(int d = 1; d < days; d++) {
            for (int j = d; j < jobs; j++) {
                dpMatrix[d][j] = minSum(jobDifficulty, dpMatrix, d+1, j+1);
            }
        }

        return dpMatrix[days-1][jobs-1];

    }

    private int minSum(int[] jobDifficulty, int[][] dpMatrix, int days, int jobs) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int j = jobs-1; j >= (days -1); j--) {
            max = Math.max(max, jobDifficulty[j]);
            int sum = dpMatrix[days-2][j-1] + max;
            min = Math.min(min, sum);
        }
        return min;
    }

}
