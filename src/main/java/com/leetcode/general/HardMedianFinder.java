package com.leetcode.general;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-median-from-data-stream/
 * Leet: 295. Find Median from Data Stream (Hard)
 * The median is the middle value in an ordered integer list. If the size of the list is even,
 * There is no middle value and the median is the mean of the two middle values.
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * Implement the MedianFinder class:
 * MedianFinder() initializes the MedianFinder object.
 * void addNum(int num) adds the integer num from the data stream to the data structure.
 * double findMedian() returns the median of all elements so far.
 * Poem Runtime: 182 ms, faster than 19.59% of Java online submissions for Find Median from Data Stream.
 * Memory Usage: 120.6 MB, less than 22.81% of Java online submissions for Find Median from Data Stream.
 */
public class HardMedianFinder {

    public static void main(String[] args) throws Exception {

        HardMedianFinder tester = new HardMedianFinder();
        tester.addNum(6);
        System.out.println("Check Answer: " + tester.findMedian());
        tester.addNum(10);
        System.out.println("Check Answer: " + tester.findMedian());
        tester.addNum(2);
        System.out.println("Check Answer: " + tester.findMedian());
        tester.addNum(6);
        System.out.println("Check Answer: " + tester.findMedian());
        tester.addNum(5);
        System.out.println("Check Answer: " + tester.findMedian());
        tester.addNum(3);
        System.out.println("Check Answer: " + tester.findMedian());

    }

    private PriorityQueue<Integer> bigQueue = new PriorityQueue<Integer>(); // number > media descending order
    private PriorityQueue<Integer> smallQueue = new PriorityQueue<Integer>(Collections.reverseOrder()); // number < media ascending order
    private Integer smallNumber = null;
    private Integer middleNumber = null;
    private Integer bigNumber = null;

    public HardMedianFinder() {
        bigQueue.add(Integer.MAX_VALUE);
        smallQueue.add(Integer.MIN_VALUE);
    }

    public void addNum(int newNumber) {

        if( middleNumber == null && smallNumber == null && bigNumber == null ) {
            middleNumber = newNumber;
            return;
        }

        if( middleNumber != null ) { // smallNum & bigNum == null
            if( newNumber > bigQueue.peek() ) {
              bigQueue.add(newNumber);
              newNumber = bigQueue.poll();
            } else if( newNumber < smallQueue.peek() ) {
                smallQueue.add(newNumber);
                newNumber = smallQueue.poll();
            }
            smallNumber = Math.min(middleNumber, newNumber);
            bigNumber = Math.max(middleNumber, newNumber);
            middleNumber = null;
            return;
        } else { // middleMiddle == null, smallNumber & bigNumber != null

            if( newNumber > bigQueue.peek() ) {
                bigQueue.add(newNumber);
                newNumber = bigQueue.poll();
            } else if( newNumber < smallQueue.peek() ) {
                smallQueue.add(newNumber);
                newNumber = smallQueue.poll();
            }

            // smallNumber, BigNumber, newNumber
            if( newNumber > bigNumber ) {
                middleNumber = bigNumber;
                bigQueue.add(newNumber);
                bigNumber = null;
                smallQueue.add(smallNumber);
                smallNumber = null;
            } else if( newNumber < smallNumber ) {
                middleNumber = smallNumber;
                bigQueue.add(bigNumber);
                bigNumber = null;
                smallQueue.add(newNumber);
                smallNumber = null;
            } else { // smallNumber < newNumber < bigNumber
                middleNumber = newNumber;
                bigQueue.add(bigNumber);
                bigNumber = null;
                smallQueue.add(smallNumber);
                smallNumber = null;
            }
            return;
        }

    }

    public double findMedian() {

        if( middleNumber != null )
            return (double) middleNumber;
        else
            return (double) (smallNumber + bigNumber) / 2.0;
    }

}
