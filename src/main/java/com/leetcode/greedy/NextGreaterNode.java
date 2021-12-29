package com.leetcode.greedy;

import java.util.HashMap;
import java.util.Stack;

/**
 * 1019. Next Greater Node In Linked List (Medium)
 * We are given a linked list with head as the first node.  Let's number the nodes in the list: node_1, node_2, node_3, ... etc.
 * Each node may have a next larger value: for node_i, next_larger(node_i) is the node_j.val such that j > i, node_j.val > node_i.val,
 * and j is the smallest possible choice.  If such a j does not exist, the next larger value is 0.
 * Return an array of integers answer, where answer[i] = next_larger(node_{i+1}).
 * Note that in the example inputs (not outputs) below, arrays such as [2,1,5] represent the serialization of a linked list
 * with a head node value of 2, second node value of 1, and third node value of 5.
 * Runtime: 47 ms, faster than 44.88% of Java online submissions for Next Greater Node In Linked List.
 * Memory Usage: 40.9 MB, less than 97.30% of Java online submissions for Next Greater Node In Linked List.
 */
public class NextGreaterNode {

    public final static void main(String[] args) {

        ListNode head = new ListNode(2);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        int[] values = nextLargerNodes(head);

        for(int i = 0; i < values.length; i++ )
            System.out.print( values[i] + " " );

    }

    public static int[] nextLargerNodes(ListNode head) {

        HashMap<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
        Stack<ListNode> stack = new Stack<ListNode>();

        int count = 0;
        ListNode curNode = head;

        while( curNode != null) {
            if( stack.empty() || stack.peek().value >= curNode.value) {
                stack.push(curNode);
                curNode = curNode.next;
                count++;
            } else {
                ListNode pop = stack.pop();
                map.put( pop, curNode );
            }
        }

        int i = 0 ;
        int[] values = new int[count];
        curNode = head;
        while( curNode != null ) {
            values[i] = map.containsKey(curNode) ? map.get(curNode).value : 0;
            curNode = curNode.next;
            i++;
        }

        return values;
    }

    public static class ListNode {

        public int value;
        public ListNode next;

        public ListNode(int v) {
            value = v;
        }

    }
}
