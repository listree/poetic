package com.leetcode.graph;
import java.util.*;

/**
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/
 * 675. Cut Off Trees for Golf Event (Hard)
 * You are asked to cut off all the trees in a forest for a golf event. The forest is represented as an m x n matrix. In this matrix:
 * 0 means the cell cannot be walked through.
 * 1 represents an empty cell that can be walked through.
 * A number greater than 1 represents a tree in a cell that can be walked through, and this number is the tree's height.
 * In one step, you can walk in any of the four directions: north, east, south, and west.
 * If you are standing in a cell with a tree, you can choose whether to cut it off.
 * You must cut off the trees in order from shortest to tallest.
 * When you cut off a tree, the value at its cell becomes 1 (an empty cell).
 * Starting from the point (0, 0), return the minimum steps you need to walk to cut off all the trees.
 * If you cannot cut off all the trees, return -1.
 * You are guaranteed that no two trees have the same height, and there is at least one tree needs to be cut off.
 */
public class HardCutOffTrees {

    public final static void main(String[] args) {
        HardCutOffTrees tester = new HardCutOffTrees();
        List<List<Integer>> forest = new ArrayList<List<Integer>>();
        Integer[] arr1 = {1, 2, 3};
        forest.add(Arrays.asList(arr1));
        Integer[] arr2 = {0, 0, 4};
        forest.add(Arrays.asList(arr2));
        Integer[] arr3 = {7, 6, 5};
        forest.add(Arrays.asList(arr3));
        System.out.println(tester.cutOffTree(forest)); // must be 6
    }

    class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean equals(Position that) {
            return this.x == that.x && this.y == that.y;
        }

        public String toString() {
            return "" + x + " " + y;
        }
    }

    public int cutOffTree(List<List<Integer>> forest) {
        HashMap<Integer, Position> hash = new HashMap<Integer, Position>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        for (int i = 0; i < forest.size(); i++) {
            List<Integer> list = forest.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).intValue() != 0) {
                    priorityQueue.add(list.get(j));
                    hash.put(list.get(j), new Position(i, j));
                }
            }
        }

        int path = 0;
        Integer height = priorityQueue.poll();
        Position position = hash.get(height);
        if (position.x != 0 || position.y != 0) {
            return -1;
        }

        while (!priorityQueue.isEmpty()) {
            Integer targetHeight = priorityQueue.poll();
            System.out.println(targetHeight);
            Position target = hash.get(targetHeight);
            int nextPath = findPath(position, target, forest);
            if (nextPath == -1)
                return -1;
            else {
                path += nextPath;
                position = target;
            }
        }

        return path;
    }

    Position marker = new Position(-1, -1);

    int findPath(Position source, Position target, List<List<Integer>> forest) {
        Queue<Position> queue = new LinkedList<Position>();
        HashSet<Integer> visited = new HashSet<Integer>();
        int path = 0;
        queue.add(source);
        queue.add(marker);
        while (!queue.isEmpty()) {
            Position current = queue.poll();
            visited.add(current.x * forest.get(0).size() + current.y);
            if (current.equals(marker)) {
                if (queue.isEmpty())
                    return -1;
                queue.add(marker);
                path++;
            } else if (current.equals(target)) {
                return path;
            } else {
                process(current.x, current.y + 1, queue, visited, forest);
                process(current.x, current.y - 1, queue, visited, forest);
                process(current.x + 1, current.y, queue, visited, forest);
                process(current.x - 1, current.y, queue, visited, forest);
            }
        }

        return -1;
    }

    void process(int x, int y, Queue<Position> queue, HashSet<Integer> visited, List<List<Integer>> forest) {
        Position p = new Position(x, y);
        if (x >= 0 && x < forest.size() && y >= 0 && y < forest.get(0).size()
                && forest.get(x).get(y) != 0 && !visited.contains(p.x * forest.get(0).size() + p.y)) {
            queue.add(p);
        }
    }

}