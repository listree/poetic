package com.leetcode;

import com.leetcode.tree.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by poet on 6/28/16.
 */
public class TreeTests {

    @Test
    public void testM102LevelOrder() {

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> list = (new M102LevelOrder()).levelOrder(root);
        Assert.assertEquals("must be 3", 3, list.size());

        Assert.assertArrayEquals("level 1 has 3", new Integer[] {3}, list.get(0).toArray());
        Assert.assertArrayEquals("level 2 has 9, 20", new Integer[] {9,20}, list.get(1).toArray());
        Assert.assertArrayEquals("level 3 has 15, 7", new Integer[] {15,7}, list.get(2).toArray());

    }

    @Test
    public void testM144PreOrder() {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = (new E144PreOrder()).preorderTraversal(root);
        Assert.assertArrayEquals("Preorder list is 1,2,3", new Integer[] {1,2,3}, result.toArray());

    }

    @Test
    public void testM94InOrder() {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> result = E94InOrder.inorderTraversal(root);
        Assert.assertArrayEquals("Preorder list is 1,3,2", new Integer[] {1,3,2}, result.toArray());

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        List<Integer> result2 = E94InOrder.inorderTraversal(root);
        Assert.assertArrayEquals("Preorder list is 4, 2, 5, 1, 6, 3, 7",
                new Integer[] {4, 2, 5, 1, 6, 3, 7},
                result2.toArray());

    }

    @Test
    public void testM173BSTIterator() {

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        M173BSTIterator iterator = new M173BSTIterator(root);
        Assert.assertEquals("return 3", 3, iterator.next());
        Assert.assertEquals("return 7", 7, iterator.next());
        Assert.assertEquals("return true", true, iterator.hasNext());
        Assert.assertEquals("return 9", 9, iterator.next());
        Assert.assertEquals("return true", true, iterator.hasNext());
        Assert.assertEquals("return 15", 15, iterator.next());
        Assert.assertEquals("return true", true, iterator.hasNext());
        Assert.assertEquals("return 20", 20, iterator.next());
        Assert.assertEquals("return true", false, iterator.hasNext());
    }

}
