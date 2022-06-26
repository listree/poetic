package com.leetcode.amazon;

import java.util.*;

/**
 *
 */
public class MediumMeetingRoomsII {
    public final static void main(String[] args) {
        MediumMeetingRoomsII tester = new MediumMeetingRoomsII();
        int[][] x = {{0, 30}, {5, 10}, {15, 20}};
        System.out.println(tester.minMeetingRooms(x));
    }

    class Meeting implements Comparable<Meeting> {
        int start;
        int end;
        Meeting(int[] interval) {
            start = interval[0];
            end = interval[1];
        }

        public int compareTo(Meeting that) {
            return this.start - that.start;
        }
    }

    public int minMeetingRooms(int[][] intervals) {

        List<Meeting> list = new ArrayList<Meeting>();
        for(int[] x: intervals) list.add(new Meeting(x));
        Collections.sort(list);

        PriorityQueue<Meeting> queue = new PriorityQueue<Meeting>(list.size(), (x,y) -> x.end - y.end);

        for (Meeting current: list) {
            if( queue.isEmpty() ) {
                queue.add(current);
                continue;
            }

            Meeting earlyEnd = queue.peek();
            System.out.println(earlyEnd.end);

            if( earlyEnd.end > current.start ) {
                queue.add(current);
            } else {
                queue.poll();
                queue.add(current);
            }
        }

        return queue.size();
    }


}
