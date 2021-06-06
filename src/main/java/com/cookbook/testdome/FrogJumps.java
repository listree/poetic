package com.cookbook.testdome;

/**
 * Created by poet on 7/19/16.
 */

public class FrogJumps {

    public static int numberOfWays(int n) {

        int last1  = 2;
        int last2  = 1;
        int pos = 3;

        while( pos <= n ) {
            int cur = last1 + last2;
            last2 = last1;
            last1 = cur;
            pos++;
        }

        return last1;
    }

    public static void main(String[] args) {
        System.out.println(numberOfWays(4));
    }

}