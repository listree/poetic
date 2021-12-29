package com.leetcode.amazon;

import java.util.*;

/**
 * Leet: 937. Reorder Data in Log Files (Easy)
 * Link: https://leetcode.com/problems/reorder-data-in-log-files/
 * You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
 * There are two types of logs:
 * Letter-logs: All words (except the identifier) consist of lowercase English letters.
 * Digit-logs: All words (except the identifier) consist of digits.
 * Reorder these logs so that:
 * The letter-logs come before all digit-logs.
 * The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them
 * lexicographically by their identifiers.
 * The digit-logs maintain their relative ordering.
 * Return the final order of the logs.
 * Poem Runtime: 3 ms, faster than 90.74% of Java online submissions for Reorder Data in Log Files.
 * Memory Usage: 39.4 MB, less than 68.74% of Java online submissions for Reorder Data in Log Files.
 */
public class EasyReorderDataLog {

    public final static void main(String[] args) {
        EasyReorderDataLog tester = new EasyReorderDataLog();
        String[] input = {"dig1 8 1 5 1",
                "let1 art can",
                "dig2 3 6",
                "let2 own kit dig",
                "let3 art zero"};
        String[] output = tester.reorderLogFiles(input);
        for(String string: output) {
            System.out.println(string);
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        List<LogObject> list = new ArrayList<LogObject>();
        for (int i = 0; i < logs.length; i++) {
            list.add(new LogObject(logs[i], i));
        }
        Collections.sort(list);
        String[] strings = new String[list.size()];
        for( int i = 0 ; i < list.size(); i++) {
            strings[i] = list.get(i).logString;
        }
        return strings;
    }

    public class LogObject implements Comparable<LogObject> {

        String logString;
        String identifier;
        String logContent;
        boolean isLetterLog;
        int order;

        public LogObject(String logString, int _order) {
            this.logString = logString;
            identifier = logString.substring(0, logString.indexOf(' '));
            logContent = logString.substring(logString.indexOf(' ') + 1);
            isLetterLog = checkLetterLog();
            order = _order;
        }

        // Each word after the identifier will consist only of lowercase letters, or;
        boolean checkLetterLog() {
            String[] tokens = logString.split(" ");
            for (int i = 1; i < tokens.length; i++) {
                for (char c : tokens[i].toCharArray()) {
                    if (c < 'a' || c > 'z') {
                        return false;
                    }
                }
            }
            return true;
        }

        /**
         Reorder the logs so that all of the letter-logs come before any digit-log.
         The letter-logs are ordered lexicographically ignoring identifier,
         with the identifier used in case of ties.
         The digit-logs should be put in their original order.
         */
        @Override
        public int compareTo(LogObject o) {
            if( this.isLetterLog && o.isLetterLog ) {
                int x = this.logContent.compareTo(o.logContent);
                if( x == 0)
                    return this.identifier.compareTo(o.identifier);
                else
                    return x;
            } else if( !this.isLetterLog && !o.isLetterLog ) {
                return this.order - o.order;
            } else if( this.isLetterLog && !o.isLetterLog ) {
                return -1;
            } else {
                return 1;
            }
        }

    }

}
