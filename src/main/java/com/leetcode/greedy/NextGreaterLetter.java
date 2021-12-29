package com.leetcode.greedy;

/**
 * 744. Find Smallest Letter Greater Than Target
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
 * find the smallest element in the list that is larger than the given target.
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * Poem Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Smallest Letter Greater Than Target.
 * Memory Usage: 38.9 MB, less than 100.00% of Java online submissions for Find Smallest Letter Greater Than Target.
 */
public class NextGreaterLetter {

    public char nextGreatestLetter(char[] letters, char target) {

        int n = letters.length;

        int lowerBound = 0;
        int upperBound = letters.length-1;

        if( target >= letters[upperBound] )
            return letters[0];

        if( target < letters[lowerBound] )
            return letters[0];

        while( lowerBound < upperBound ) {

            if( (upperBound - lowerBound) == 1 )
                return letters[upperBound];

            int test = (lowerBound + upperBound) / 2;

            if( target < letters[test] ) {
                upperBound = test;
            } else {
                lowerBound = test;
            }

        }

        return letters[upperBound];

    }

}
