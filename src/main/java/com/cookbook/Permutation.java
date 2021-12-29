package com.cookbook;

/**
 * This will print out all permutations of array of characters
 * and return total of permutations at end
 */
public class Permutation {

    public final static void main(String[] ars) {

        char[] chars = {'A', 'B', 'C', 'D', 'E'};
        int total = permute(0, chars);
        System.out.println("Total permutations:" + total);

    }

    public static int permute(int start, char[] chars) {

        int total = 0;
        if (start == (chars.length - 1)) {
            prettyPrint(chars);
            total = 1;
        }

        for (int j = start; j < chars.length; j++) {
            swap(start, j, chars); //swap forward, j = start, no op
            total += permute(start + 1, chars); // rest permute
            swap(start, j, chars);  //swap back
        }

        return total;
    }

    private static void swap(int i, int j, char[] chars) {
        if( i == j ) return;
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    private static void prettyPrint(char[] chars) {
        for (int k = 0; k < chars.length; k++)
            System.out.print(chars[k]);
        System.out.println();
    }

}