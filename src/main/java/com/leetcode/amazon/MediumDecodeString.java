package com.leetcode.amazon;

import java.util.Stack;

/**
 * Leet: 394. Decode String (Medium)
 * Link: https://leetcode.com/problems/decode-string/
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly
 * k times. Note that k is guaranteed to be a positive integer. You may assume that the input string is always valid;
 * there are no extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * Runtime: 11 ms, faster than 6.06% of Java online submissions for Decode String.
 * Memory Usage: 39.4 MB, less than 6.48% of Java online submissions for Decode String.
 */
public class MediumDecodeString {

    public static final void main(String[] args) {
        MediumDecodeString tester = new MediumDecodeString();
        String s1 = "3[a]2[bc]";
        System.out.println(tester.decodeString(s1)); // Output: "aaabcbc"
        String s2 = "3[a2[c]]";
        System.out.println(tester.decodeString(s2)); // Output: "accaccacc"
        String s3 = "2[abc]3[cd]ef";
        System.out.println(tester.decodeString(s3)); // Output: "abcabccdcdcdef"
        String s4 = "100[leetcode]";
        System.out.println(tester.decodeString(s4)); // Output: "leetcode......"
    }

    public String decodeString(String s) {

        String decodedString = "";
        String numString = "";
        Stack<Character> stack = new Stack<Character>();

        for( int i = 0 ; i < s.length(); i++ ) {
            char c = s.charAt(i);
            if( c >= '0' && c <= '9' ) {
                numString += c;
            } else if (c == '[') {
                for (int j = i; j < s.length(); j++) {
                    char jc = s.charAt(j);
                    if (jc == '[') stack.push(jc);
                    if (jc == ']') { // next closure ']'
                        stack.pop();
                        if (stack.isEmpty()) {
                            String subString = decodeString(s.substring(i + 1, j));
                            int repeated = Integer.parseInt(numString);
                            while (repeated-- > 0) {
                                decodedString += subString;
                            }
                            i = j;
                            numString = "";
                            break;
                        }
                    }
                }
            } else {
                decodedString += c;
            }
        }

        return decodedString;

    }

}
