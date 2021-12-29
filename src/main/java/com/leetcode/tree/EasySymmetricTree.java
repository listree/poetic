package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/symmetric-tree/
 * 101. Symmetric Tree (Easy)
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * Runtime: 1 ms, faster than 47.51% of Java online submissions for Symmetric Tree.
 * Memory: 39.3 MB, less than 17.97% of Java online submissions for Symmetric Tree.
 */
public class EasySymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if( root == null)
            return true;

        return checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if( left == null && right == null)
            return true;

        if( left != null && right != null) {
            if (left.val != right.val)
                return false;
            return checkSymmetric(left.left, right.right) &&
                    checkSymmetric(left.right, right.left);
        }
        return false;
    }

}
