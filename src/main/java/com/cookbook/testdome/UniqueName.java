package com.cookbook.testdome;

import java.util.*;

/**
 * Created by poet on 7/19/16.
 */
public class UniqueName {

    public static void main(String[] args) {
        System.out.println(firstUniqueName(new String[] { "Abbi", "Adeline", "Abbi", "Adalia" }));
    }

    public static String firstUniqueName(String[] names) {

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for( String string : names ) {
            if( map.containsKey(string) ) {
                map.put(string, map.getOrDefault(string, 0) + 1);
            } else {
                map.put(string, 1);
            }
        }

        for( String string : names ) {
            int count = map.get(string);
            if( count == 1)
                return string;
        }

        return null;
    }

}