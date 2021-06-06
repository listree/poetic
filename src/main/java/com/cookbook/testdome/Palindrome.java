package com.cookbook.testdome;

/**
 * Created by poet on 7/19/16.
 */
public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Noel sees Leon."));

    }

    public static boolean isPalindrome(String str) {

        str = str.toLowerCase();

        int left = 0 ;
        int right = str.length() - 1;

        while(  left < str.length() && (str.charAt(left) < 'a' || str.charAt(left) > 'z') ) {
            left++;
        }

        while( right > -1 && (str.charAt(right) < 'a' || str.charAt(right) > 'z') ) {
            right--;
        }

        while( right > left ) {

            if( str.charAt(left) != str.charAt(right) )
                return false;

            left++;
            while(  left < str.length() && (str.charAt(left) < 'a' || str.charAt(left) > 'z') ) {
                left++;
            }

            right--;
            while( right > -1 && (str.charAt(right) < 'a' || str.charAt(right) > 'z') ) {
                right--;
            }


        }
        return true;
    }


}