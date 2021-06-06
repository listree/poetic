package com.cookbook.datastruct;

import com.cookbook.datastruct.ReverseList.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class ReverserTest {

    @Test
    public void testListOf0Item() {
        ListNode head = null;
        ListNode reversed = ReverseList.reverse(head);
        Assert.assertNull(null, reversed);
    }

    @Test
    public void testListOf1Item() {
        ListNode head = new ListNode("a");
        ListNode reversed = ReverseList.reverse(head);
        Assert.assertNotNull(null, reversed);
        Assert.assertNotNull("a", reversed.data);
        Assert.assertNull(null, reversed.next);
    }

    @Test
    public void testListIf2MoreItems() {

        ListNode nodeA = new ListNode("a");
        ListNode nodeB = new ListNode("b");
        ListNode nodeC = new ListNode("c");
        nodeA.next = nodeB; nodeB.next = nodeC;
        ListNode reversed = ReverseList.reverse(nodeA);

        Assert.assertNotNull(null, reversed);
        Assert.assertNotNull("c", reversed.data);

        reversed = reversed.next;
        Assert.assertNotNull(null, reversed);
        Assert.assertNotNull("b", reversed.data);

        reversed = reversed.next;
        Assert.assertNotNull(null, reversed);
        Assert.assertNotNull("a", reversed.data);

        reversed = reversed.next;
        Assert.assertNull(null, reversed);
    }

}