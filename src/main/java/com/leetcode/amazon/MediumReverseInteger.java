package com.leetcode.amazon;

public class MediumReverseInteger {

    public final static void main(String[] args) {
        MediumReverseInteger tester = new MediumReverseInteger();
        System.out.println(tester.reverse(123)); // 321
        System.out.println(tester.reverse(1534236469)); // 0
    }

    public int reverse(int x) {
        long reversed = 0;
        int y = x;
        if( x < 0 ) {
            y = -x;
        }
        while( y > 0) {
            int remainder = y % 10;
            reversed = reversed * 10 + remainder;
            y = y / 10;
        }

        if( reversed > Integer.MAX_VALUE)
            return 0;

        if( x < 0 )
            return  (int) (-reversed);
        else
            return (int) reversed;

    }

}
