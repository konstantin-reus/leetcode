package com.reus.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule-ii
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        Map<Integer, TreeNode> valToNodes = buildGraph(prerequisites, numCourses);
        Queue<TreeNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(t -> t.in.size()));

        for (TreeNode node : valToNodes.values()) {
            minHeap.add(node);
        }

        int[] result = new int[numCourses];
        int writePointer = 0;
        while (!minHeap.isEmpty()) {
            TreeNode cur = minHeap.poll();
            if (cur.in.isEmpty()) {
                result[writePointer++] = cur.val;
            } else {
                return new int[0];
            }
            Set<Integer> out = cur.out;
            for (int outNodeVal : out) {
                TreeNode next = valToNodes.get(outNodeVal);
                next.in.remove(cur.val);
                minHeap.remove(next);
                minHeap.add(next);
            }
        }
        return result;
    }

    private static class TreeNode {
        int val;
        Set<Integer> out = new HashSet<>();
        Set<Integer> in = new HashSet<>();
        public TreeNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return String.format("Val=%d, in=%s, out=%s", val, in, out);
        }
    }

    private Map<Integer, TreeNode> buildGraph(int[][] order, int numCourses) {
        Map<Integer, TreeNode> result = new HashMap<>();
        for (int[] edge : order) {
            // 1 - from, 0 - to
            result.putIfAbsent(edge[0], new TreeNode(edge[0]));
            result.putIfAbsent(edge[1], new TreeNode(edge[1]));
            result.get(edge[0]).in.add(edge[1]);
            result.get(edge[1]).out.add(edge[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!result.containsKey(i)) {
                result.put(i, new TreeNode(i));
            }
        }
        return result;
    }
}
