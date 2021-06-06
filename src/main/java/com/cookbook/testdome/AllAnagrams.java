package com.cookbook.testdome;

/**
 * Created by codepoet on 7/19/16.
 */
import java.util.*;

public class AllAnagrams {

    public static Collection<String> getAllAnagrams(String string) {

        if( string == null || string.length() == 0 ) {
            return new HashSet<String>();
        }

        if( string.length() == 1 ) {
            HashSet<String> set = new HashSet<String>();
            set.add(string);
            return set;
        }

        HashMap<Character, Integer> map  = new HashMap<Character, Integer>();
        for( int i = 0 ; i < string.length(); i ++ ) {
            if( map.containsKey(string.charAt(i)) ) {
                map.put(string.charAt(i), map.get(string.charAt(i))+ 1);
            } else {
                map.put(string.charAt(i), 1);
            }
        }

        HashSet<String> set = new HashSet<String>();
        for( char c: map.keySet() ) {
            String substring =  formSubString(map, c);
            Collection<String> collection = getAllAnagrams(substring);
            for( String newstring : collection)
                set.add( "" + c + newstring);
        }
        return set;
    }

    public static String formSubString(HashMap<Character, Integer> map, char ex) {
        String string  = "";
        for( Character c : map.keySet() ) {
            int count = map.get(c);
            if( c == ex ) {
                count = count - 1;
            }
            for( int i = 0 ; i < count ; i++ ) {
                string += c;
            }
        }
        return string;
    }




    public static void main(String[] args) {
        Collection<String> anagrams = getAllAnagrams("abba");
        for (String a : anagrams)
            System.out.println(a);
    }
}