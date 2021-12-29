package com.leetcode.amazon;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * Leet: 236. Lowest Common Ancestor of a Binary Tree (Medium)
 * Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * Runtime: 7 ms, faster than 35.76% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
 * Memory Usage: 42.9 MB, less than 23.11% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
 */
public class MediumLCAncestor {

    public static void main(String[] args) {
        int test = 2;
        /*        3
         *     5    1
         *   6  2  0 8
         *     7 4
         * p = 5, q = 1 Output: 3
         * p = 5, q = 4 Output: 5
         */
        MediumLCAncestor tester = new MediumLCAncestor();
        if( test == 1 ){
            TreeNode root3 = new TreeNode(3);
            TreeNode node5 = new TreeNode(5);
            TreeNode node1 = new TreeNode(1);
            root3.left = node5;
            root3.right = node1;

            node5.left = new TreeNode(6);
            node5.right = new TreeNode(2);

            node1.left = new TreeNode(0);
            node1.right = new TreeNode(8);

            TreeNode node7 = new TreeNode(7);
            TreeNode node4 = new TreeNode(4);
            node5.right.left = node7;
            node5.right.right = node4;

            TreeNode result = tester.lowestCommonAncestor(root3, node5, node1);
            System.out.println("Check Answer: " + (result == root3));

            TreeNode result2 = tester.lowestCommonAncestor(root3, node5, node4);
            System.out.println("Check Answer: " + (result2 == node5));
        }

        if( test == 2) {
            TreeNode node37 = new TreeNode(37);
            TreeNode node_48 = new TreeNode(-48);
            TreeNode node48 = new TreeNode(48);
            TreeNode node_54 = new TreeNode(-54);
            TreeNode node_71 = new TreeNode(-71);
            node37.right = node_48;
            node_48.right = node48;
            node48.left = node_54;
            node_54.left = node_71;

            Stack<TreeNode> stack = new Stack<TreeNode>();
            tester.searchNode(node37, node_71, stack);
            TreeNode result = tester.lowestCommonAncestor(node37, node_71, node48);
            System.out.println("Check Answer: " + (result.val == 48));
        }
    }

    // stack: root to node
    private void searchNode(TreeNode root, TreeNode node, Stack<TreeNode> stack) {

        if( root == null )
            return;

        stack.push(root);
        if( root.val == node.val) {
            return;
        }

        if (root.left != null ) {
            searchNode(root.left, node, stack);
            if (stack.peek().val == node.val)
                return;
            else if (!stack.isEmpty())
                stack.pop();
        }

        if (root.right != null ) {
            searchNode(root.right, node, stack);
            if (stack.peek().val == node.val)
                return;
            else if (!stack.isEmpty())
                stack.pop();
        }

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stackP = new Stack<TreeNode>();
        searchNode(root, p, stackP);

        Stack<TreeNode> stackQ = new Stack<TreeNode>();
        searchNode(root, q, stackQ);

        while( stackP.size() > stackQ.size() ) {
            stackP.pop();
        }

        while( stackP.size() < stackQ.size() ) {
            stackQ.pop();
        }


        while( !stackP.isEmpty() && !stackQ.isEmpty() ) {
            TreeNode ancestorP = stackP.pop();
            TreeNode ancestorQ = stackQ.pop();
            if(ancestorP.val == ancestorQ.val)
                return ancestorP;
        }

        return root;
    }

}
