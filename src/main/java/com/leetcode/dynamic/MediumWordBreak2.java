package com.leetcode.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by poet on 12/1/19.
 */
public class MediumWordBreak2 {

    public final static void main(String[] args) {

        List<String> wordDict = Arrays.asList(new String[]{"cat", "cats", "and", "sand", "dog"});
        List<String> list = wordBreak ("catsanddog", wordDict);
        list.forEach(string -> System.out.println(string));

        wordDict =  Arrays.asList(new String[]{"a", "b"});;
        list = wordBreak ("ab", wordDict);
        list.forEach(string -> System.out.println(string));

    }

    /*
    Runtime: 8 ms, faster than 27.24% of Java online submissions for Word Break II.
    Memory Usage: 37.1 MB, less than 100.00% of Java online submissions for Word Break II.
    */
    public static List<String> wordBreak(String s, List<String> wordDict) {


        List<Integer>[] canBreak = new List[s.length()]; // default is null

        for(int i = 0 ; i < s.length(); i++) {
            canBreak[i] = new ArrayList<Integer>();
        }

        for( String word : wordDict ) {
            if( s.startsWith(word) )
                canBreak[word.length()-1].add(-1);
        }

        for(int i = 0; i < s.length(); i++ ) {

            if(canBreak[i].isEmpty())
                continue;

            for( String word : wordDict ) {

                if( i + word.length() < s.length() ) {
                    if (s.substring(i + 1).startsWith(word)) {
                        canBreak[i + word.length()].add(i);
                    }
                }

            }
        }

        return buildList(s, canBreak, s.length() - 1, "");


    }

    private static List<String> buildList(String s, List<Integer>[] canBreak, int end, String postFix ) {

        List<String> list = new ArrayList<String>();

        if( !canBreak[end].isEmpty() ) {
            for(Integer index: canBreak[end] ) {
                if( index  == -1 )
                    list.add( s.substring(index+1, end+1) + (postFix.isEmpty() ? "": " " + postFix));
                else {
                    String newPostFix = s.substring(index+1, end+1) + (postFix.isEmpty() ? "": " " + postFix);
                    list.addAll(buildList(s, canBreak, index, newPostFix));
                }
            }
        }

        return list;

    }

}
