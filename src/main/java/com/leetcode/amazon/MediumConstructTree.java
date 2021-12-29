package com.leetcode.amazon;

import com.leetcode.*;

/**
 * Leet: 105. Construct Binary Tree from Preorder and Inorder Traversal  (Medium)
 * Link: https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree
 * and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * Runtime: 7 ms, faster than 12.50% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
 * Memory Usage: 41.5 MB, less than 20.46% of Java online submissions for Construct Binary Tree from Preorder and Inorder Traversal.
 */
public class MediumConstructTree {
    public static final void main(String[] args) {

        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        //    Output: [3,9,20,null,null,15,7]
        //   3
        // 9   20
        //    15 7
        MediumConstructTree tester = new MediumConstructTree();
        TreeNode root = tester.buildTree(preorder, inorder);
        System.out.println(root.val == 3);
        System.out.println(root.left.val == 9);
        System.out.println(root.right.val == 20);
        System.out.println(root.right.left.val == 15);
        System.out.println(root.right.right.val == 7);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode buildTree(int[] preorder, int i1, int i2, int[] inorder, int j1, int j2) {
        int val = preorder[i1];
        TreeNode root = new TreeNode(val);
        int k = j1;
        for(; k <= j2; k++) {
            if( inorder[k] == val)
                break;
        }

        int leftSize = k - j1;
        int rightSize = i2 - i1 - leftSize;

        if( leftSize > 0)
            root.left = buildTree(preorder, i1+1, i1 + leftSize, inorder, j1, j1 + leftSize - 1);

        if( rightSize > 0)
            root.right = buildTree(preorder, i2 - rightSize + 1, i2, inorder, j2 - rightSize + 1,  j2);

        return root;
    }

}
