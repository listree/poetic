package com.leetcode.facebook;

public class CountSubArrays {

    public final static void main(String[] args) {

        int[] arr = {3, 4, 1, 6, 2};
        int[] output = new CountSubArrays().countSubarrays(arr);

        // output [1, 3, 1, 5, 1]
        for( int o : output) {
            System.out.print(o + " ");
        }

    }

    int[] countSubarrays(int[] arr) {
        // Write your code here
        if (arr.length == 0)
            return new int[0];

        int[] ending = new int[arr.length];
        int[] starting = new int[arr.length];
        int[] output = new int[arr.length];

        ending[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                ending[i] = ending[i - 1] + 1;
            else
                ending[i] = 0;
        }

        starting[arr.length - 1] = 0;
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1])
                starting[i] = starting[i - 1] + 1;
            else
                starting[i] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            output[i] = starting[i] + ending[i] + 1;
        }

        return output;
    }

}
