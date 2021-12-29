package com.leetcode.tree;

import com.leetcode.*;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 103. Binary Tree Zigzag Level Order Traversal (Medium)
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 * Runtime: 2 ms, faster than 26.71% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 * Memory: 42.1 MB, less than 71.77% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 */
public class MediumLevelZigzag {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        if( root == null)
            return levelOrderList;

        // Initialize base structure
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode marker = null;
        queue.add(root);
        queue.add(marker);

        boolean leftToRight = true;
        List<Integer> currentLevel = new ArrayList<Integer>();

        while( !queue.isEmpty() ) {

            TreeNode curNode = queue.poll();

            if( curNode != marker ) {
                if( leftToRight)
                    currentLevel.add(curNode.val);
                else
                    currentLevel.add(0, curNode.val);

                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);

            } else {
                levelOrderList.add(currentLevel);
                currentLevel = new ArrayList<Integer>();
                leftToRight = !leftToRight;

                if( !queue.isEmpty() )
                    queue.add(curNode);

            }

        }
        return levelOrderList;
    }

}
