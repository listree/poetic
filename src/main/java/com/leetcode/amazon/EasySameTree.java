package com.leetcode.amazon;

import com.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/same-tree/
 * Leet: 100. Same Tree (Easy)
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 * Poem Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
 * Memory Usage: 36.5 MB, less than 65.51% of Java online submissions for Same Tree.
 */
public class EasySameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q == null ) {
            return true;
        }
        if( p != null && q != null ) {
            if( p.val != q.val )
                return false;
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
