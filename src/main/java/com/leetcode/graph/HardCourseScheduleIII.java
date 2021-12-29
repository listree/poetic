package com.leetcode.graph;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-iii/
 * 630. Course Schedule III (Hard)
 * There are n different online courses numbered from 1 to n. You are given an array courses where courses[i] =
 * [durationi, lastDayi] indicate that the ith course should be taken continuously for durationi days and must be finished
 * before or on lastDayi. You will start on the 1st day and you cannot take two or more courses simultaneously.
 * Return the maximum number of courses that you can take.
 * Runtime: 90 ms, faster than 14.69% of Java online submissions for Course Schedule III.
 * Memory: 68.8 MB, less than 68.68% of Java online submissions for Course Schedule III.
 */
public class HardCourseScheduleIII {

    public final static void main(String[] args) {
        HardCourseScheduleIII tester = new HardCourseScheduleIII();

        int[][] courses = {{100,200}, {200,1300}, {1000,1250}, {2000,3200}};
        int result = tester.scheduleCourse(courses);
        System.out.println(result);

        int[][] courses2 = {{5,5}, {4,6}, {2,6}};
        int result2 = tester.scheduleCourse(courses2);
        System.out.println(result2);
    }

    public static class Course {
        int duration;
        int lastDay;
        Course(int[] array) {
            this.duration = array[0];
            this.lastDay = array[1];
        }

        public String toString() {
            return "" + duration + " " + lastDay;
        }
    }

    public int scheduleCourse(int[][] courses) {

        Course[] sortedCourses = new Course[courses.length];
        for(int i = 0; i < courses.length; i++)
            sortedCourses[i] = new Course(courses[i]);
        Arrays.sort(sortedCourses, (a, b) -> a.lastDay - b.lastDay);

        PriorityQueue<Course> priorityQueue = new PriorityQueue<Course>((a, b) -> b.duration - a.duration);
        int totalTime = 0;
        for(Course course: sortedCourses) {
            priorityQueue.add(course);
            totalTime = totalTime + course.duration;
            if (totalTime > course.lastDay) {
                Course pollCourse = priorityQueue.poll();
                totalTime = totalTime - pollCourse.duration;
            }
        }
        return priorityQueue.size();

    }

}
