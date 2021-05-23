package com.reus.leetcode.util;

import java.util.*;

/**
 * https://leetcode.com/problems/course-schedule
 */
public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule c = new CourseSchedule();
        boolean result = c.canFinish(2, new int[][] { {1,0}});
        System.out.println(result);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses, prerequisites);
        if (graph.hasCycle()) {
            return false;
        }
        return graph.getConnectedVertices() == numCourses;
    }

    private static class Graph {
        private final boolean[] marked;
        private final Map<Integer, List<Integer>> adjacent;

        private int markedCount;

        public Graph(int verticesNum, int[][] edges) { //edge[0] -> edge[1]
            marked = new boolean[verticesNum + 1];

            adjacent = new HashMap<>();
            adjacent.put(-1, new ArrayList<>());
            for (int i = 0; i < verticesNum; i++) {
                adjacent.get(-1).add(i);
            }
            for (int[] edge : edges) {
                adjacent.putIfAbsent(edge[0], new ArrayList<>());
                adjacent.get(edge[0]).add(edge[1]);

            }
            markReachable(-1);
        }

        private void markReachable(int verticeNum) {
            List<Integer> adjacentNodes = adjacent.getOrDefault(verticeNum, new ArrayList<>());
            marked[verticeNum + 1] = true;
            markedCount++;
            for (int adj : adjacentNodes) {
                if (!marked[adj + 1]) {
                    markReachable(adj);
                }
            }
        }

        public boolean hasCycle() {
            boolean[] visited = new boolean[marked.length];
            boolean[] recursionStack = new boolean[marked.length];
            return hasCycle(-1, visited, recursionStack);
        }

        private boolean hasCycle(int cur, boolean[] visited, boolean[] recursionStack) {
            if (recursionStack[cur + 1]) {
                return true;
            }
            if (visited[cur + 1]) {
                return false;
            }
            visited[cur + 1] = true;
            recursionStack[cur + 1] = true;
            List<Integer> adj = adjacent.getOrDefault(cur, new ArrayList<>());
            for (int a : adj) {
                if (hasCycle(a, visited, recursionStack)) {
                    return true;
                }
            }
            recursionStack[cur + 1] = false;
            return false;
        }


        public int getConnectedVertices() {
            return markedCount - 1;
        }
    }
}
