package com.leetcode.greedy;

import com.leetcode.TreeNode;

/**
 * 1038. Binary Search Tree to Greater Sum Tree
 * https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 Given the root of a binary search tree with distinct values, modify it so that every node has a new value
 equal to the sum of the values of the original tree that are greater than or equal to node.val.
 As a reminder, a binary search tree is a tree that satisfies these constraints:

 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.


 Example 1:

 Input: [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 Output: [30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]

 Note:

 The number of nodes in the tree is between 1 and 100.
 Each node will have value between 0 and 100.
 The given tree is a binary search tree.

 */
public class MediumBst2Gst
{

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Search Tree to Greater Sum Tree.
     * Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Binary Search Tree to Greater Sum Tree.
     */
    public TreeNode bstToGst(TreeNode root) {

        bstToGst(root, 0);
        return root;

    }

    public TreeNode bstToGst(TreeNode root, int sum) {

        if( root == null )
            return root;

        TreeNode rightLeftMost = null;
        if( root.right != null ) {
            rightLeftMost = bstToGst(root.right, sum);
        }

        if( rightLeftMost != null)
            root.val += rightLeftMost.val;
        else
            root.val += sum;

        TreeNode leftLeftMost = root;
        if( root.left != null ) {
            leftLeftMost = bstToGst(root.left, root.val);
        }

        return leftLeftMost;

    }

}