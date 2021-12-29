package com.leetcode.amazon;

import com.leetcode.TreeNode;

/**
 * Link: https://leetcode.com/problems/diameter-of-binary-tree/
 * Leet: 543. Diameter of Binary Tree (Easy)
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * The length of a path between two nodes is represented by the number of edges between them.
 * Peom Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
 * Memory Usage: 40.6 MB, less than 28.76% of Java online submissions for Diameter of Binary Tree.
 */
public class EasyDiameterOfTree {

    public final static void main(String[] args) {
        int x = 1534236469;
        EasyDiameterOfTree tester = new EasyDiameterOfTree();
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n2 = new TreeNode(2, n4, n5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n1 = new TreeNode(1, n2, n3);

        System.out.println(tester.diameterOfBinaryTree(n1)); // 3

    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        findDepth(root, maxDiameter);
        return maxDiameter[0];
    }

    public int findDepth(TreeNode root, int[] maxDiameter) {

        if( root == null )
            return 0;

        int leftDepth = 0;
        if( root.left != null )
            leftDepth = findDepth(root.left, maxDiameter) + 1;

        int rightDepth = 0;
        if( root.right != null )
            rightDepth = findDepth(root.right, maxDiameter) + 1;


        int diameter = leftDepth + rightDepth;
        maxDiameter[0] = Math.max(maxDiameter[0], diameter);
        //System.out.println( root.val + " " + leftDepth + " " + rightDepth + " "  + diameter);

        return Math.max(leftDepth, rightDepth);


    }

}
