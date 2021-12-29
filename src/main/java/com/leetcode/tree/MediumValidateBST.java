package com.leetcode.tree;

import com.leetcode.TreeNode;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 * Question: 98. Validate Binary Search Tree (Medium)
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * Runtime: 1 ms, faster than 52.82% of Java online submissions for Validate Binary Search Tree.
 * Memory: 44.4 MB, less than 18.25% of Java online submissions for Validate Binary Search Tree. 
 */
public class MediumValidateBST {

    public final static void main(String[] args) {
        // [5,4,6,null,null,3,7]
        TreeNode root5 = new TreeNode(5);
        TreeNode root4 = new TreeNode(4);
        TreeNode root6 = new TreeNode(6);
        TreeNode root3 = new TreeNode(3);
        TreeNode root7 = new TreeNode(7);
        root5.left = root4;
        root5.right = root6;
        root6.left = root3;
        root6.right = root7;

        System.out.println(new MediumValidateBST().isValidBST(root5));
        TreeNode root2147483647 = new TreeNode(2147483647);
        System.out.println(new MediumValidateBST().isValidBST(root2147483647));

        // [3,1,5,0,2,4,6,null,null,null,3]

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long lowerBound, long upperBound) {

        if( root == null )
            return true;

        if( root.val <= lowerBound || root.val >= upperBound)
            return false;

        return isValidBST(root.left, lowerBound, root.val) && 
                isValidBST(root.right, root.val, upperBound);

    }
    
}
