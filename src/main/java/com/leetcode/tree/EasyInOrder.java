package com.leetcode.tree;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * Question: 95
 * Ref: https://leetcode.com/problems/binary-tree-inorder-traversal/
 Given a binary tree, return the inorder traversal of its nodes' values.
 Example: Input: [1,null,2,3]
 1
   \
    2
   /
  3
 Output: [1,3,2]
 */
public class EasyInOrder {

    /**
     * Recursive solution is trivial, so do it iteratively, UnitTest: [[com.leetcode.TreeTests]]
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
     * Memory Usage: 37.7 MB, less than 13.56% of Java online submissions for Binary Tree Inorder Traversal.
     */
    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;

        while( current != null || !stack.isEmpty() ) {

            if( current == null ) {
                current = stack.pop();
                list.add(current.val); // stack top insert into ordered list
                current = current.right; // immediate process its right tree
            } else {
                stack.push(current);  // candidate to process by order
                current = current.left; // go deeper into left
            }

        } // end of while

        return list;

    }

}
