package com.cookbook.hackerrank;

import java.util.Scanner;

/**
 * Created by poet on 2/28/17.
 */
public class CountingSort {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        int[] ar = new int[100];
        for (int i = 0; i < s; i++) {
            ar[i] = 0;
        }

        for (int i = 0; i < 100; i++) {
            int n = scanner.nextInt();
            ar[n]++;
        }

        for(int n = 0; n < 100; n++) {
            if( ar[n] > 0 ) {
                for( int i = 0 ; i < ar[n]; i++)
                    System.out.print(n + " ");
            }
        }

        System.out.println("");
    }

}
