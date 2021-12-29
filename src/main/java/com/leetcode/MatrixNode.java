package com.leetcode;

public class MatrixNode {

    public static void print(int[][] data) {
        for(int i = 0; i < data.length; i++) {
            for(int j = 0; j < data[0].length; j++) {
                System.out.print(data[i][j] + ((j == (data[0].length -1)) ? "\n" : " " ));
            }
        }
    }

}
