package com.leetcode.design;

import com.leetcode.TreeNode;
import java.util.*;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 297. Serialize and Deserialize Binary Tree (Hard)
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
 * in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another
 * computer environment. Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
 * to a string and this string can be deserialized to the original tree structure. Clarification: The input/output format
 * is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format,
 * so please be creative and come up with different approaches yourself.
 * Note: Level Traversal Time Limit Exceeded, changed to preorder
 * Runtime: 44 ms, faster than 23.10% of Java online submissions for Serialize and Deserialize Binary Tree.
 * Memory: 52.7 MB, less than 42.27% of Java online submissions for Serialize and Deserialize Binary Tree.
 */

public class HardSerializeBinaryTree {

    public final static void main(String[] args) {
        HardSerializeBinaryTree tester = new HardSerializeBinaryTree();
        String string = "1,2,#,#,3,4,#,#,5,#,#";
        TreeNode root = tester.deserialize(string);
        String dstring = tester.serialize(root);
        System.out.println("root: " + root );
        System.out.println("dstring: " + dstring );

        System.out.println(tester.serialize(null));
        System.out.println(tester.deserialize("#"));

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        List<String> list = new ArrayList<>();
        while( !stack.isEmpty() ) {
            TreeNode node = stack.pop();
            if (node == null) {
                list.add("#");
            } else {
                list.add("" + node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }

        return String.join(",", list);

    }

    // Decodes your encoded data to tree.
    int index = 0;
    public TreeNode deserialize(String data) {

        index = 0;
        String[] strings = data.split(",");
        return deserialize(strings);
    }

    TreeNode deserialize(String[] arr) {
        if (arr[index].equals("#"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(arr[index]));
        index++;
        root.left = deserialize(arr);
        index++;
        root.right = deserialize(arr);
        return root;
    }

}
