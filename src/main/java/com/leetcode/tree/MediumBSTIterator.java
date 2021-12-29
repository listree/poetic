package com.leetcode.tree;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * Question: 173. Binary Search Tree Iterator
 * Description: https://leetcode.com/problems/binary-search-tree-iterator/
 * Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
 * BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor.
 * The pointer should be initialized to a non-existent number smaller than any element in the BST.
 * boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
 * int next() Moves the pointer to the right, then returns the number at the pointer.
 * Notice that by initializing the pointer to a non-existent smallest number,
 * the first call to next() will return the smallest element in the BST.
 * You may assume that next() calls will always be valid.
 * That is, there will be at least a next number in the in-order traversal when next() is called.
 * For Example:
 *    7
 *  3   15
 *     9 21
 * Follow up:
 * implement next() and hasNext() to run in average O(1) time and use O(h) memory, where h is the height of the tree?
 */

public class MediumBSTIterator {

    public static void main(String[] args) {
        // binary search tree
        TreeNode n9 = new TreeNode(9);
        TreeNode n21 = new TreeNode(21);
        TreeNode n15 = new TreeNode(15, n9, n21);
        TreeNode n3 = new TreeNode(3);
        TreeNode root = new TreeNode(7, n3, n15);
        MediumBSTIterator iterator = new MediumBSTIterator(root);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }

    Queue<Integer> queue = new LinkedList<>();

    //Runtime: 16 ms, faster than 40.54% of Java online submissions for Binary Search Tree Iterator.
    //Memory Usage: 42.4 MB, less than 83.91% of Java online submissions for Binary Search Tree Iterator.
    public MediumBSTIterator(TreeNode root) {

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {

            if (current == null) {
                current = stack.pop();
                // only put stack top into ordered list
                queue.add(current.val);
                //after process stack top, immediate process its right tree
                current = current.right;

            } else {
                // candidate for process by order
                stack.push(current);
                // go further into left
                current = current.left;
            }

        }
    }

    /** @return the next smallest number */
    public int next() {
        return queue.poll();

    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }

}
