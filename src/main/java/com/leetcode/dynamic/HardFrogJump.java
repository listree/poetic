package com.leetcode.dynamic;

import java.util.*;

/**
 * 403. Frog Jump (Hard)
 * https://leetcode.com/problems/frog-jump/
 * A frog is crossing a river. The river is divided into some number of units, and at each unit, there may or may not
 * exist a stone. The frog can jump on a stone, but it must not jump into the water.
 * Given a list of stones' positions (in units) in sorted ascending order, determine if the frog can cross the river
 * by landing on the last stone. Initially, the frog is on the first stone and assumes the first jump must be 1 unit.
 * If the frog's last jump was k units, its next jump must be either k - 1, k, or k + 1 units. The frog can only jump
 * in the forward direction.
 * Runtime: 291 ms, faster than 8.58% of Java online submissions for Frog Jump.
 * Memory: 122.2 MB, less than 10.46% of Java online submissions for Frog Jump.
 */

public class HardFrogJump {

    public final static void main(String[] args) {
        HardFrogJump tester = new HardFrogJump();
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        System.out.println( tester.canCross(stones) );
    }

    public boolean canCross(int[] stones) {
        final int n = stones.length;
        // dp[i][j] = true if a frog can make a j units jump to stones[i]
        int[][] dp = new int[n][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i < n; ++i)
            for (int j = 0; j < i; ++j) {
                int k = stones[i] - stones[j];
                if (k >= n) continue;
                for (int d = -1; d <= 1; d++) {
                    int pre = d + k;
                    if (0 <= pre && pre <= n && dp[j][pre] == 1) {
                        dp[i][k] = 1;
                        break;
                    }
                }
            }

        return Arrays.stream(dp[n - 1]).anyMatch(x -> x == 1);
    }

}
