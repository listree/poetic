package com.cookbook.hackerrank;

/**
 * Created by poet on 2/28/17.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMedian {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        List<Integer> numbers = new ArrayList<Integer>();
        for(int i = 0; i < s; i++){
            numbers.add((Integer) scanner.nextInt());
        }
        System.out.println( findNthItem(numbers, numbers.size() / 2 ) );
    }

    static Integer findNthItem(List<Integer> items, int n) {

        Integer pivot = items.get(0);
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> equal = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();

        for(Integer item: items) {
            if( item < pivot ) {
                left.add(item);
            } else if( item > pivot ) {
                right.add(item);
            } else {
                equal.add(item);
            }
        }

        if( left.size() > n )
            return findNthItem(left, n);
        else if( left.size() + equal.size() > n )
            return pivot;
        else
            return findNthItem(right, n - left.size() - equal.size());

    }


}