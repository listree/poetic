package com.cookbook.datastruct;

public class ReverseList {


    public final static void main(String[] args) {

        ListNode nodeA = new ListNode("a");
        ListNode nodeB = new ListNode("b");
        ListNode nodeC = new ListNode("c");
        ListNode nodeD = new ListNode("d");

        ListNode head = nodeA;
        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;

        ListNode newHead = reverse(head);
        ListNode.printList(newHead);

    }

    public static ListNode reverse(ListNode head) {

        ListNode newHead = null;
        ListNode curNode = head;
        ListNode oldHead;

        while( curNode != null ) {

            oldHead = curNode.next;
            curNode.next = newHead;
            newHead = curNode;
            curNode = oldHead;
        }

        return newHead;

    }

    public static class ListNode {

        public Object data;
        public ListNode next;
        public String x;

        //Just test it
        public static void main(String[] args) {
           ListNode node1 = new ListNode(1);
           ListNode node2 = new ListNode(2);
           ListNode node3 = new ListNode(3);
            node1.next = node2;
            node2.next = node3;
            printList(node1);
        }

        public ListNode(Object data) {
            this.data = data;
        }

        //utility methods
        public static void printList(ListNode head) {

            if( head == null )
                return;

           ListNode curNode = head;
            while( curNode != null ) {
                if( curNode == head )
                    System.out.print(curNode);
                else
                    System.out.print("->" + curNode);
                curNode = curNode.next;
            }

            System.out.println("->null");
        }

        public String toString() {
            return data.toString();
        }

    }
}
