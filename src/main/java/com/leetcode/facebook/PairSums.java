package com.leetcode.facebook;

import java.util.*;

public class PairSums {


    public final static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 3};
        int output = new PairSums().numberOfWays(arr, 6);
        System.out.println("output="+ output);

        int[] arr2 = {1, 5, 3, 3, 3};
        int output2 = new PairSums().numberOfWays(arr2, 6);
        System.out.println("output2="+ output2);

    }

    int numberOfWays(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0 ; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int total = 0 ;
        for (int i : map.keySet()) {
            if (i != k - i && map.containsKey(k - i)) {
                total += map.get(i) * map.get(k - i);
            }
        }

        total = total / 2;
        if( k % 2 == 0 ) {
            int half = k / 2;
            if( map.containsKey(half) ) {
                int n = map.get(half);
                if( n > 1)
                    total += n * (n - 1) / 2;
            }
        }

        return total;

    }

}
