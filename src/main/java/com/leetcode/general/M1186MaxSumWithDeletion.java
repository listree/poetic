package com.leetcode.general;

/**
 * Question 1186. Maximum Subarray Sum with One Deletion
 * Description: https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
 * Created by poet on 12/2/19.
 */
public class M1186MaxSumWithDeletion {

    /*
    Runtime: 3 ms, faster than 82.66% of Java online submissions for Maximum Subarray Sum with One Deletion.
    Memory Usage: 47.3 MB, less than 33.78% of Java online submissions for Maximum Subarray Sum with One Deletion.
     */
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int fw[] = new int[n];
        int bw[] = new int[n];

        // Initialize current max and max so far.
        int cur_max = arr[0];
        int max_so_far = arr[0];

        // calculating maximum sum subarrays in forward direction
        fw[0] = arr[0];
        for (int i = 1; i < n; i++) {
            cur_max = Math.max(arr[i], cur_max + arr[i]);
            max_so_far = Math.max(max_so_far, cur_max);
            fw[i] = cur_max;
        }

        cur_max = max_so_far = bw[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            cur_max = Math.max(arr[i], cur_max + arr[i]);
            max_so_far = Math.max(max_so_far, cur_max);
            bw[i] = cur_max;
        }

        int fans = max_so_far;
        // choosing maximum ignoring ith element
        for (int i = 1; i < n - 1; i++)
            fans = Math.max(fans, fw[i - 1] + bw[i + 1]);

        return fans;
    }
}
