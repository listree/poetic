package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * 124. Binary Tree Maximum Path Sum (Hard)
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge
 * connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * The path sum of a path is the sum of the node's values in the path.
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * Runtime: 1 ms, faster than 86.88% of Java online submissions for Binary Tree Maximum Path Sum.
 * Memory: 47.9 MB, less than 37.85% of Java online submissions for Binary Tree Maximum Path Sum.
 */
public class HardMaxPathSum {

    public final static void main(String[] args) {
        HardMaxPathSum tester = new HardMaxPathSum();

        // [      -10,
        //    9,         20,
        // null, null, 15, 7
        // ] ans: 42
        TreeNode root = new TreeNode(-10, 9, 20);
        root.right = new TreeNode(20, 15, 7);
        System.out.println( tester.maxPathSum(root) );

        // [                5,
        //       4,                   8,
        //  11,    null,         13,   4,
        // 7, 2, null, null, null, 1
        // ]
        // ans: 48
    }

    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxPathSum(root, max);
        return max[0];
    }

    public int maxPathSum(TreeNode root, int[] max) {
        if( root == null )
            return 0 ;

        int leftMax = Math.max(maxPathSum(root.left, max), 0);
        int rightMax = Math.max(maxPathSum(root.right, max), 0);

        int localMax = root.val + leftMax + rightMax;
        max[0] = Math.max(max[0], localMax);
        return root.val + Math.max(leftMax, rightMax);

    }

}
