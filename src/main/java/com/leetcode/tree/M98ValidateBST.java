package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * Question: 98. Validate Binary Search Tree
 * Ref: https://leetcode.com/problems/validate-binary-search-tree/
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *      5
 *  4      6 (lower bound, upper bound)
 *        3  7
 */
public class M98ValidateBST {

    public final static void main(String[] args) {
        //[5,4,6,null,null,3,7]
        TreeNode root5 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        TreeNode root6 = new TreeNode(6);
        TreeNode root3 = new TreeNode(3);
        TreeNode root7 = new TreeNode(7);
        root5.left = root4;
        root5.right = root6;
        root6.left = root3;
        root6.right = root7;

        System.out.println(new M98ValidateBST().isValidBST(root5));
        TreeNode root2147483647 = new TreeNode(2147483647);
        System.out.println(new M98ValidateBST().isValidBST(root2147483647));

        //    [3,1,5,0,2,4,6,null,null,null,3]

    }

    /**
        Runtime: 29 ms, faster than 6.35% of Java online submissions for Validate Binary Search Tree.
        Memory Usage: 39.5 MB, less than 15.39% of Java online submissions for Validate Binary Search Tree.
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long lowerbound, long upperbound) {

        if( root == null )
            return true;

        if( root.val <= lowerbound || root.val >= upperbound)
            return false;

        return isValidBST(root.left, lowerbound, root.val) && isValidBST(root.right, root.val, upperbound);

    }
}
