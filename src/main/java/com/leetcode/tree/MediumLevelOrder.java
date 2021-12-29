package com.leetcode.tree;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 102. Binary Tree Level Order Traversal (Medium)
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * Runtime: 1 ms, faster than 81.59% of Java online submissions for Binary Tree Level Order Traversal.
 * Memory: 42.1 MB, less than 97.37% of Java online submissions for Binary Tree Level Order Traversal.
*/

public class MediumLevelOrder {
    public static void main(String[] args) {
        MediumLevelOrder tester = new MediumLevelOrder();

        // [3, 9, 20, null, null, 15, 7]
        TreeNode root = new TreeNode(3, 9, 20);
        root.right = new TreeNode(20, 15, 7);
        List<List<Integer>> levels = tester.levelOrder(root);
        printLevelOrder(levels); // [[3],[9, 20],[15, 7]]

        // [1]
        printLevelOrder(tester.levelOrder(new TreeNode(1)));

        // []
        root = null;
        printLevelOrder(tester.levelOrder(root));

    }

    static void printLevelOrder(List<List<Integer>> levels) {
        for (int i = 0; i < levels.size(); i++) {
            for (int j = 0; j < levels.get(i).size(); j++) {
                System.out.print(levels.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        if( root == null)
            return levelOrderList;

        // Initialize base structure
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode levelBreak = null;
        queue.add(root);
        queue.add(levelBreak);
        List<Integer> currentLevel = new ArrayList<Integer>();

        while( !queue.isEmpty() ) {

            TreeNode curNode = queue.poll();

            if( curNode != null ) {
                currentLevel.add(curNode.val);

                if (curNode.left != null)
                    queue.add(curNode.left);

                if (curNode.right != null)
                    queue.add(curNode.right);

            } else { // case of curNode == null
                // add whole list of integer to return list
                levelOrderList.add(currentLevel);

                currentLevel = new ArrayList<Integer>();
                if( !queue.isEmpty() )
                    queue.add(curNode);
            }

        }

        return levelOrderList;
    }

}
