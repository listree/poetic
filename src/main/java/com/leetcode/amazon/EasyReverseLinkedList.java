package com.leetcode.amazon;

import com.leetcode.ListNode;

/**
 * Leet: 206. Reverse Linked List (Easy)
 * Link: https://leetcode.com/problems/reverse-linked-list/
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * Poem Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
 * Memory Usage: 40 MB, less than 13.99% of Java online submissions for Reverse Linked List.
 */
public class EasyReverseLinkedList {

    public final static void main(String[] args) {

        EasyReverseLinkedList tester = new EasyReverseLinkedList();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        ListNode result = tester.reverseList(node1);
        System.out.println(result.printTail());

    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode oldHead = head;
        while ( oldHead != null ) {
            ListNode headNext = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = headNext;
        }
        return newHead;
    }

}
