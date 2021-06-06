package com.cookbook.testdome;

/**
 * Created by poet on 7/19/16.
 */

public class ValidBST {

    public static void main(String[] args) {

        Node n1 = new Node(1, null, null);
        Node n3 = new Node(3, null, null);
        Node n2 = new Node(2, n1, n3);

        System.out.println(isValidBST(n2));
    }

    static class Node {
        public int value;
        public Node left, right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValidBST(Node root) {

        if( root == null )
            return true;

        if( root.left != null) {

            if (!isValidBST(root.left))
                return false;

            Node leftRight = root.left;
            while (leftRight != null ) {
                if (leftRight.value > root.value)
                    return false;
                leftRight = leftRight.right;
            }

        }

        if( root.right != null) {

            if (!isValidBST(root.right))
                return false;

            Node rightLeft= root.right;
            while (rightLeft != null ) {
                if (rightLeft.value < root.value)
                    return false;
                rightLeft = rightLeft.left;
            }

        }

        return true;
    }

}