package com.leetcode;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        return "Node(" + val + ")";
    }

    public String serializeList() {
        String string = "";
        ListNode node = this;
        while (node != null) {
            string += node + "->";
            node = node.next;
        }
        string += "null";
        return string;
    }

}