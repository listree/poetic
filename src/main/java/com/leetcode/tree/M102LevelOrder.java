package com.leetcode.tree;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * Question: 102. Binary Tree Level Order Traversal
 * Description: https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level). For example:
 * Given binary tree [3,9,20,null,null,15,7],
        3
       / \
      9  20
     /     \
    15      7
     return its level order traversal as:
     [
     [3],
     [9,20],
     [15,7]
     ]
*/

public class M102LevelOrder {
    public static void main(String[] args) {
        M102LevelOrder tester = new M102LevelOrder();
        //        Example 1:
        //        Input:
        //        root = [3, 9, 20, null, null, 15, 7]
        //        Output: [[3],[9, 20],[15, 7]]
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, node9, node20);
        List<List<Integer>> levels = tester.levelOrder(node3);
        tester.printAll(levels);
//        Example 2:
//        Input:
//        root = [1]
//        Output: [[1]]
        tester.printAll(tester.levelOrder(new TreeNode(1)));

//        Example 3:
//        Input: root = []
//        Output: []
        tester.printAll(tester.levelOrder(null));

    }

    public void printAll(List<List<Integer>> levels) {
        for (int i = 0; i < levels.size(); i++) {
            for (int j = 0; j < levels.get(i).size(); j++) {
                System.out.print(levels.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
    Memory Usage: 39.4 MB, less than 38.79% of Java online submissions for Binary Tree Level Order Traversal.
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        if( root == null)
            return levelOrderList;

        // Initialize base structure
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        TreeNode levelBreak = null;
        nodeQueue.add(root);
        nodeQueue.add(levelBreak);
        List<Integer> currentLevel = new ArrayList<Integer>();

        while( !nodeQueue.isEmpty() ) {

            TreeNode curNode = nodeQueue.poll();

            if( curNode != null ) {
                currentLevel.add(curNode.val);

                if (curNode.left != null)
                    nodeQueue.add(curNode.left);

                if (curNode.right != null)
                    nodeQueue.add(curNode.right);

            } else { // case of curNode == null
                // add whole list of integer to return list
                levelOrderList.add(currentLevel);

                currentLevel = new ArrayList<Integer>();
                if( !nodeQueue.isEmpty() )
                    nodeQueue.add(curNode);
            }

        }

        return levelOrderList;
    }

}
