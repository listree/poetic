package com.leetcode.graph;

import com.leetcode.MatrixNode;

/**
 * https://leetcode.com/problems/flood-fill/
 * 733. Flood Fill (Easy)
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from
 * the pixel image[sr][sc]. To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally
 * to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels
 * (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 * Return the modified image after performing the flood fill.
 * Runtime: 1 ms, faster than 81.91% of Java online submissions for Flood Fill.
 * Memory: 48.6 MB, less than 7.36% of Java online submissions for Flood Fill.
 */
public class EasyFloodFill {

    public final static void main(String[] args) {
        EasyFloodFill easy = new EasyFloodFill();
        int[][] image = {{1,1,1}, {1,1,0}, {1,0,1}};
        int sr = 1, sc = 1, newColor = 2;
        easy.floodFill(image, sr, sc, newColor);

        MatrixNode.print(image);

        int[][] image2 = {{0,0,0}, {0,0,0}};
        sr = 0; sc = 0; newColor = 2;
        easy.floodFill(image2, sr, sc, newColor);
        MatrixNode.print(image2);

        int[][] image3 = {{0,0,0}, {0,1,1}};
        sr = 1; sc = 1; newColor = 1;
        easy.floodFill(image3, sr, sc, newColor);
        MatrixNode.print(image3);

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if( oldColor == newColor)
            return image;

        floodFill(image, sr, sc, oldColor, newColor);
        return image;
    }

    public void floodFill(int[][] image, int sr, int sc, int oldColor, int newColor) {
        if( sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length ) {
            return;
        }

        if( image[sr][sc] == oldColor) {
            image[sr][sc] = newColor;
            floodFill(image, sr + 1, sc, oldColor, newColor);
            floodFill(image, sr - 1, sc, oldColor, newColor);
            floodFill(image, sr, sc + 1,  oldColor, newColor);
            floodFill(image, sr, sc - 1, oldColor, newColor);
        }

    }
}
