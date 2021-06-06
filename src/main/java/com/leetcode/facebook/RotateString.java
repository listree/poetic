package com.leetcode.facebook;

public class RotateString {

    public final static void main(String[] args) {

        System.out.println(
            new RotateString().rotationalCipher("a", 3)
        );

    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuffer buf = new StringBuffer();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if( c >= '0' && c <= '9' ) {
                int pos = (c - '0' + rotationFactor) % 10;
                buf.append( (char)('0' + pos));
            } else if( c >= 'a' && c <= 'z' ) {
                int pos = (c - 'a' + rotationFactor) % 26;
                buf.append( (char)('a' + pos));
            } else if( c >= 'A' && c <= 'Z' ) {
                int pos = (c - 'A' + rotationFactor) % 26;
                buf.append( (char)('A' + pos));
            } else {
                buf.append(c);
            }
        }
        return buf.toString();
    }

}
