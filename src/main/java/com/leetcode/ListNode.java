package com.leetcode;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        return "Node" + val;
    }

    public String printTail() {
        String string = "";
        ListNode node = this;
        while (node != null) {
            string += node.val + "->";
            node = node.next;
        }
        return string;
    }

}