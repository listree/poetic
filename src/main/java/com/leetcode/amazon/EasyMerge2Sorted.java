package com.leetcode.amazon;

import com.leetcode.ListNode;

/**
 * Leet: 21. Merge Two Sorted Lists (Easy)
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * Poem Runtime: 1 ms, faster than 46.20% of Java online submissions for Merge Two Sorted Lists.
 * Memory Usage: 39.9 MB, less than 29.05% of Java online submissions for Merge Two Sorted Lists.
 */
public class EasyMerge2Sorted {

    public final static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        EasyMerge2Sorted tester = new EasyMerge2Sorted();
        ListNode head = tester.mergeTwoLists(list1, list2);
        while( head != null ) {
            System.out.println(head.val);
            head = head.next;
        }

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode head = null;
        if (list1 == null) {
            head = list2;
            list2 = list2.next;
        } else if (list2 == null) {
            head = list1;
            list1 = list1.next;
        } else if (list1.val < list2.val) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }
        ListNode current = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                current = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = list2;
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            current.next = list1;
            current = list1;
            list1 = list1.next;
        }

        while (list2 != null) {
            current.next = list2;
            current = list2;
            list2 = list2.next;
        }

        return head;
    }
}