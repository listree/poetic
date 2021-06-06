package com.cookbook.datastruct;

/**
 * Created by a poet on 3/13/17.
l */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 8 ,9, 0};
        QuickSort.printArray("Before: ", arr);
        QuickSort.sortIt(arr, 0, arr.length-1);
        QuickSort.printArray("After: ", arr);

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        QuickSort.printArray("Before: ", arr2);
        QuickSort.sortIt(arr2, 0, arr2.length-1);
        QuickSort.printArray("After: ", arr2);

        int[] arr3 = {7, 6, 5, 4, 3, 2, 1};
        QuickSort.printArray("Before: ", arr3);
        QuickSort.sortIt(arr3, 0, arr3.length-1);
        QuickSort.printArray("After: ", arr3);

    }

    static void sortIt(int[] arr, int start, int end) {

        if( start >= end)
            return;

        int left = start;
        int right = end;

        int pivot = arr[(left + right)/2] ;

        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (arr[right] > pivot) {
                right--;
            }

            if (left <= right) {
                // swap
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        //printArray("Pivot=" + pivot + "left=" + left + "right=" + right + ": ",  arr);

        if (right > start) {
            sortIt(arr, start, right);
        }

        if (left < end) {
            sortIt(arr, left, end);
        }

    }

    private static void printArray(String message, int[] arr) {
        System.out.print(message);
        for(int i: arr){
            System.out.print(i + " ");
        }
        System.out.println("");
    }

}
