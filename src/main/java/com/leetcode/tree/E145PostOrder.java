package com.leetcode.tree;

import com.leetcode.TreeNode;

import java.util.*;

/** Question:  145
 * Ref: https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * Example:
 Input: [1,null,2,3]
     1
      \
       2
      /
     3
 Output: [3,2,1]
 Follow up: Recursive solution is trivial, could you do it iteratively?
*/

public class E145PostOrder {

    public final static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(postorderTraversal(root));

    }

    /*
        Runtime: 1 ms, faster than 13.34% of Java online submissions for Binary Tree Postorder Traversal.
        Memory Usage: 37.7 MB, less than 13.03% of Java online submissions for Binary Tree Postorder Traversal.
     */
    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if( root == null)
            return list;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while( !stack.empty() ) {
            TreeNode cur = stack.pop();
            list.add(cur.val);

            if (cur.left != null)
                stack.push(cur.left);

            if (cur.right != null)
                stack.push(cur.right);

        }

        Collections.reverse(list);
        return list;

    }

}
