package com.leetcode.tree;

import com.leetcode.TreeNode;

/** Question: 1028. Recover a Tree From Preorder Traversal
 * Description: https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/
 * We run a preorder depth-first search (DFS) on the root of a binary tree.
 * At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.
 * If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.
 * If a node has only one child, that child is guaranteed to be the left child.
 *
 * Given the output traversal of this traversal, recover the tree and return its root.
 Example 1:
 Input: "1-2--3--4-5--6--7"
 Output: [1,2,5,3,4,6,7]
 Example 2:
 Input: "1-2--3---4-5--6---7"
 Output: [1,2,5,3,null,6,null,4,null,7]
 Example 3:
 Input: "1-401--349---90--88"
 Output: [1,401,null,349,88,90]
 Note:
 The number of nodes in the original tree is between 1 and 1000.
 Each node will have a value between 1 and 10^9.
 */

public class H1028RecoverTree {

    public final static void main(String[] args) {
        H1028RecoverTree tester = new H1028RecoverTree();
        String s1 = "1-2--3--4-5--6--7";
        TreeNode n1 = tester.recoverFromPreorder(s1);
    }

    //Runtime: 8 ms, faster than 32.62% of Java online submissions for Recover a Tree From Preorder Traversal.
    //Memory Usage: 39.6 MB, less than 62.57% of Java online submissions for Recover a Tree From Preorder Traversal.
    public TreeNode recoverFromPreorder(String s) {
        return recoverFromPreorder(s, "-");
    }

    public TreeNode recoverFromPreorder(String wholeString, String delimiter) {

        if( wholeString.length() == 0 )
            return null;

        int leftStartIndex = wholeString.indexOf(delimiter);
        int rootVal = 0;
        if( leftStartIndex == -1 )
            rootVal = Integer.parseInt(wholeString);
        else
            rootVal = Integer.parseInt(wholeString.substring(0, leftStartIndex));
        TreeNode root = new TreeNode(rootVal);

        if( leftStartIndex == -1 ) {
            root.left = null;
            root.right = null;
        } else {

            int rightStart = findNextDelimiter(wholeString.substring(leftStartIndex + delimiter.length()), delimiter.length());

            if( rightStart == -1 ) {
                String leftSubTree = wholeString.substring(leftStartIndex + delimiter.length());
                root.left = recoverFromPreorder(leftSubTree, delimiter + "-");
                root.right = null;
            } else {
                String leftSubTree = wholeString.substring(leftStartIndex + delimiter.length(), leftStartIndex + delimiter.length() + rightStart);
                String rightSubTree = wholeString.substring(leftStartIndex + delimiter.length() + rightStart + delimiter.length());
                root.left = recoverFromPreorder(leftSubTree, delimiter + "-");
                root.right = recoverFromPreorder(rightSubTree, delimiter + "-");
            }
        }

        return root;

    }

    static int findNextDelimiter(String string, int noDash) {

        int index = 0;
        int count = 0;
        while( index < string.length() ) {
            if( string.charAt(index) == '-' ) {
                count++;

            } else {
                if(count == noDash) //found it
                    return index - count;
                count = 0;
            }
            index++;
        }

        return -1;

    }

}
