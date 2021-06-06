package com.leetcode.greedy;

import java.util.*;

/**
 * 68. Text Justification
 * https://leetcode.com/problems/text-justification/

 Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and
 is fully (left and right) justified. You should pack your words in a greedy approach; that is, pack as many words
 as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

 Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide
 evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 For the last line of text, it should be left justified and no extra space is inserted between words.

 Note:

 A word is defined as a character sequence consisting of non-space characters only.
 Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 The input array words contains at least one word.
 Example 1:

 Input:
 words = ["This", "is", "an", "example", "of", "text", "justification."]
 maxWidth = 16
 Output:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 Example 2:

 Input:
 words = ["What","must","be","acknowledgment","shall","be"]
 maxWidth = 16
 Output:
 [
 "What   must   be",
 "acknowledgment  ",
 "shall be        "
 ]
 Explanation: Note that the last line is "shall be    " instead of "shall     be",
 because the last line must be left-justified instead of fully-justified.
 Note that the second line is also left-justified becase it contains only one word.
 Example 3:

 Input:
 words = ["Science","is","what","we","understand","well","enough","to","explain",
 "to","a","computer.","Art","is","everything","else","we","do"]
 maxWidth = 20
 Output:
 [
 "Science  is  what we",
 "understand      well",
 "enough to explain to",
 "a  computer.  Art is",
 "everything  else  we",
 "do                  "
 ]
 */
public class HardTextJustify {

    public final static void main(String[] args) {

        //String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        String[] words = {"What","must","be","acknowledgment","shall","be"};

        List<String> listString = fullJustify(words, 16);
        for( String line: listString)
            System.out.println(line);

    }

    /*
    Runtime: 4 ms, faster than 6.20% of Java online submissions for Text Justification.
    Memory Usage: 36.3 MB, less than 97.22% of Java online submissions for Text Justification.
     */
    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> list = new ArrayList<String>();
        int start = 0, end = 0, width = 0 ;

        for( int i = 0; i < words.length; i++) {
            width += words[i].length();
            if( start != i)
                width += 1;
            if( ((i + 1) < words.length) && (width + words[i+1].length() + 1) <= maxWidth) {
                continue;
            } else {
                end = i;
                if( i == (words.length - 1) ) {
                    String line = processLast(start, end, words, maxWidth, width);
                    list.add(line);
                } else {
                    String line = process(start, end, words, maxWidth, width);
                    list.add(line);
                }
                start = i + 1;
                width = 0;
            }
        }
        return list;
    }

    static String processLast(int start, int end, String[] words, int maxWidth, int width) {

        String line = words[start];
        for(int i = start + 1; i <= end; i ++ ) {
            line += " " + words[i];
        }
        line += new String(new char[maxWidth - width]).replace("\0", " ");
        return line;
    }

    static String process(int start, int end, String[] words, int maxWidth, int width) {

        int gaps = end - start;
        int extraSpaces = maxWidth - width;
        if (gaps == 0 )
            return words[start] + new String(new char[extraSpaces]).replace("\0", " ");

        int extraPerGap = extraSpaces / gaps;
        int firstN = extraSpaces % gaps;
        String spaces = new String(new char[extraPerGap+1]).replace("\0", " ");

        String line = words[start];
        for(int i = start + 1; i <= end; i ++ ) {
            line += spaces;
            if( i <= (start + firstN) )
                line += " ";
            line += words[i];
        }

        return line;
    }

}
