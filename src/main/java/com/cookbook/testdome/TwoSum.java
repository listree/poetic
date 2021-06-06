package com.cookbook.testdome;

/**
 * Created by poet on 7/19/16.
 */
import java.util.*;

public class TwoSum {

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 1, 3, 5, 7, 9 }, 12);
        System.out.println(indices[0] + " " + indices[1]);
    }

    public static int[] findTwoSum(int[] list, int sum) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int i = 0; i < list.length; i++ ) {
            map.put(list[i], i);
        }

        for( Integer integer : map.keySet() ) {
            int target = sum - integer;
            if( map.containsKey(target) ) {
                int[] found = new int[2];
                found[0] = map.get(integer);
                found[1] = map.get(target);
                return found;
            }

        }
        return null;

    }

}