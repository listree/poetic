package com.leetcode.general;

import com.leetcode.ListNode;

/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 25. Reverse Nodes in k-Group (Hard)
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not
 * a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * Runtime: 1 ms, faster than 62.06% of Java online submissions for Reverse Nodes in k-Group.
 * Memory: 45.3 MB, less than 72.54% of Java online submissions for Reverse Nodes in k-Group.
 */
public class HardReverseKGroup {
    public final static void main(String[] args) {

        HardReverseKGroup hard = new HardReverseKGroup();
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode result = hard.reverseKGroup(node1, 3);
        System.out.println(result.serializeList());

    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode[] headNextHead = reverseSublist(head, k);
        ListNode[] headNextHead2 = headNextHead;
        ListNode lastTail = head;

        while( headNextHead2[0] != headNextHead2[1] ) {
            ListNode newTail = headNextHead2[1];
            headNextHead2 = reverseSublist(headNextHead2[1], k);
            lastTail.next = headNextHead2[0];
            lastTail = newTail;
        }
        return headNextHead[0];

    }

    public ListNode[] reverseSublist(ListNode subhead, int k) {

        // System.out.println("subhead: " + subhead.serializeList());

        //  scan see if count < k, then stop
        ListNode[] ret = {subhead, subhead};
        int count = 0;
        ListNode tempNode = subhead;
        while ( tempNode != null && count < k ) {
            count++;
            tempNode = tempNode.next;
        }
        if( count < k )
            return ret;

        ListNode newHead = null;
        ListNode oldHead = subhead;
        tempNode = null;
        while ( oldHead != null && k-- > 0 ) {
            tempNode = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = tempNode;
        }
        subhead.next = tempNode;
        ListNode[] ret2 = {newHead, tempNode};
        return ret2;

    }

}
