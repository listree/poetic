package com.cookbook.hackerrank;

import java.util.*;

public class FindMissing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for(int i = 0; i < s; i++){
            Integer a = new Integer(scanner.nextInt());
            if( map.containsKey(a) ) {
                map.put(a, new Integer(map.get(a) + 1));
            } else {
                map.put(a, new Integer(1));

            }
        }

        int t = scanner.nextInt();
        for(int i = 0; i < t; i++){
            Integer b = new Integer(scanner.nextInt());
            if( map.containsKey(b) ) {
                map.put(b, new Integer(map.get(b) - 1));
            } else {
                map.put(b, new Integer(-1));
            }
        }

        for( Integer num : map.keySet() ) {
            if( map.get(num) < 0 ) {
                System.out.print(num + " ");
            }
        }


    }

}