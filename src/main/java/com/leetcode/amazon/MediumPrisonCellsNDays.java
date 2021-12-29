package com.leetcode.amazon;
import java.util.*;

/**
 * https://leetcode.com/problems/prison-cells-after-n-days/
 * There are 8 prison cells in a row and each cell is either occupied or vacant.
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.
 * You are given an integer array cells where cells[i] == 1 if the ith cell is occupied and cells[i] == 0 if the ith cell
 * is vacant, and you are given an integer n.
 * Return the state of the prison after n days (i.e., n such changes described above).
 * Runtime: 10 ms, faster than 14.86% of Java online submissions for Prison Cells After N Days.
 * Memory: 44.1 MB, less than 21.07% of Java online submissions for Prison Cells After N Days.
 */
public class MediumPrisonCellsNDays {
    public final static void main(String[] args) {
        MediumPrisonCellsNDays tester = new MediumPrisonCellsNDays();
        // int[] cells = {1,1,0,1,1,0,1,1};
        // int[] ndays = tester.prisonAfterNDays(cells, 6);
        // System.out.println(Arrays.toString(ndays)); // [0,0,1,0,0,1,0,0]

        int[] cells2 = {1,0,0,1,0,0,1,0};
        int[] ndays2 = tester.prisonAfterNDays(cells2, 1000 * 1000 * 1000);
        System.out.println(Arrays.toString(ndays2)); // [0,0,1,0,0,1,0,0]

    }

    public int[] prisonAfterNDays(int[] cells, int n) {
        // serialized string & its position
        HashMap<String, Integer> cache = new HashMap<String, Integer> ();
        HashMap<Integer, int[]> history = new HashMap<Integer, int[]>();
        int position = 0;
        cache.put(Arrays.toString(cells), position);
        history.put(position, cells);
        // System.out.println(Arrays.toString(cells) + "- "+ position);

        int[] next = null;
        while( position < n ) {
            position++;
            next = nextDay(cells);
            // System.out.println(Arrays.toString(next) + "- "+ position);
            String key = Arrays.toString(next);
            if( cache.containsKey(key) ) {
                int past = cache.get(key);
                int cycle = position - cache.get(key);
                    return history.get( past +(n - position) % cycle);
            } else {
                cache.put(key, position);
                history.put(position, next);
            }
            cells = next;
        }
        return next;
    }

    private int[] nextDay(int[] cells) {
        int[] nextDay = new int[8];
        for (int i = 1; i < 7; i++)
            nextDay[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
        return nextDay;
    }

}
