package com.leetcode;

import com.leetcode.graph.M842SplitIntoFibonacci;
import com.leetcode.tree.E144PreOrder;
import com.leetcode.tree.E94InOrder;
import com.leetcode.tree.M102LevelOrder;
import com.leetcode.tree.M173BSTIterator;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by code poet on 06/13/21.
 */
public class GraphTests {

    @Test
    public void testM842SplitIntoFibonacci() {

        List<Integer> result = (new M842SplitIntoFibonacci()).splitIntoFibonacci("123");
        Assert.assertArrayEquals("Fibonacci list is 1,2,3", new Integer[] {1,2,3}, result.toArray());

        List<Integer> result2 = (new M842SplitIntoFibonacci()).splitIntoFibonacci("123456579");
        Assert.assertArrayEquals("Fibonacci list is 123,456,579", new Integer[] {123,456,579}, result2.toArray());

    }

}