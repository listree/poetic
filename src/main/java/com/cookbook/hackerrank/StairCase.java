package com.cookbook.hackerrank;

/**
 * Created by poet on 2/27/17.
 */
public class StairCase {

    public final static void main(String[] args) {
        int n = 10;

        char[] charArray = new char[n];

        for(int i = 0 ; i < n; i++ ) {
            charArray[i] = ' ';
        }

        for(int i = 0; i < n; i++) {
            charArray[n-i-1] = '#';
            System.out.println(new String(charArray));

        }

    }
}
