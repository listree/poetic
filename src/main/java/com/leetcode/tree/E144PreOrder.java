package com.leetcode.tree;

import com.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Question: 144. Binary Tree Preorder Traversal
 * Ref: https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Example:
 Input: [1,null,2,3]
    1
     \
      2
     /
    3
 Output: [1,2,3]
 Follow up: Recursive solution is trivial, could you do it iteratively?
 */

public class E144PreOrder {

    public final static void main(String[] args) {
        E144PreOrder tester = new E144PreOrder();
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        root1.right = root2;
        root2.left = root3;

        List<Integer> list = tester.preorderTraversal(root1);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
     * Memory Usage: 37.2 MB, less than 64.17% of Java online submissions for Binary Tree Preorder Traversal.
     */
    public List<Integer> preorderTraversal(TreeNode root) {

        if( root == null)
            return new ArrayList();

        List preorderList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);

        while( !stack.isEmpty() ) {
            TreeNode curNode = stack.pop();

            preorderList.add(curNode.val);
            if (curNode.right != null) {
                stack.push(curNode.right);
            }

            if (curNode.left != null) {
                stack.push(curNode.left);
            }

        } // end of while


        return preorderList;
    }

}
