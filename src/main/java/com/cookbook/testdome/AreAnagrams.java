package com.cookbook.testdome;

/**
 * Created by poet on 7/19/16.
 */

import java.util.*;

public class AreAnagrams {

    public static void main(String[] args) {
        System.out.println(areAnagrams("dog", "god"));
        System.out.println(areAnagrams("abc", "xyz"));
    }

    public static boolean areAnagrams(String strA, String strB) {

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for( char c : strA.toCharArray() ) {
            map.put(c, map.getOrDefault(c, 0) + 1 );
        }

        for( char c : strB.toCharArray() )
            map.put(c, map.getOrDefault(c, 0) - 1);

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if( entry.getValue() != 0)
                return false;
        }

        return true;
    }

}
