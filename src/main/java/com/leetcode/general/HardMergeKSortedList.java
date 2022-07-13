package com.leetcode.general;

import com.leetcode.ListNode;

import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 23. Merge k Sorted Lists (Hard)
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * Runtime: 7 ms, faster than 64.82% of Java online submissions for Merge k Sorted Lists.
 * Memory: 47.3 MB, less than 51.86% of Java online submissions for Merge k Sorted Lists.
 */
public class HardMergeKSortedList {

    public final static void main(String[] args) {
        HardMergeKSortedList ha = new HardMergeKSortedList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        ListNode[] lists = {head, head2, head3};
        ListNode list = ha.mergeKLists(lists);
        System.out.println(list.serializeList());

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode tail = null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(
                (x,y) -> x.val - y.val
        );

        for( ListNode node: lists) {
            if( node != null)
                queue.add(node);
        }

        while( !queue.isEmpty() ) {
            ListNode node = queue.poll();
            if( head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
            if( node.next != null)
                queue.add(node.next);
        }
        return head;

    }
}
