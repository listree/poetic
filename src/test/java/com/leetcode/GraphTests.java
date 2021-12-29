package com.leetcode;

import com.leetcode.graph.MediumSplitIntoFib;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by code poet on 06/13/21.
 */
public class GraphTests {

    @Test
    public void testM842SplitIntoFibonacci() {

        List<Integer> result = (new MediumSplitIntoFib()).splitIntoFibonacci("123");
        Assert.assertArrayEquals("Fibonacci list is 1,2,3", new Integer[] {1,2,3}, result.toArray());

        List<Integer> result2 = (new MediumSplitIntoFib()).splitIntoFibonacci("123456579");
        Assert.assertArrayEquals("Fibonacci list is 123,456,579", new Integer[] {123,456,579}, result2.toArray());

    }

}