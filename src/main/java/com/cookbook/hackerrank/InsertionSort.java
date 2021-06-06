package com.cookbook.hackerrank;

import java.util.*;

public class InsertionSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=scanner.nextInt();
        }
        insertionSortPart2(ar);

    }

    public static void insertionSortPart2(int[] ar)
    {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided

        int n = ar.length;
        for(int i = 1; i < n; i++) { //1 - > n-1

            // [0,i] insert ith into right position [0,i-1]
            int e = ar[i];
            int j = i - 1;
            for(; j > -1; j--) {
                if(ar[j] > e) {
                    ar[j+1] = ar[j];
                } else {
                    ar[j+1] = e;
                    break;
                }
            }

            if( j == -1 ) {
                ar[0] = e;

            }


            printArray(ar);
        }

    }

    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}