package com.reus.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CriticalConnections {
    class Solution {
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            List<List<Integer>> result = new ArrayList<>();
            if (connections.size() == 0) {
                return result;
            }
            Map<Integer, List<Integer>> graph = makeGraph(connections);

            for (List<Integer> removedEdge : connections) {
                List<Integer> node = new ArrayList<>();
                checkConnection(graph, 0, node, new int[n], removedEdge);
                if (node.size() < n) {
                    result.add(removedEdge);
                }
            }

            return result;

        }

        private Map<Integer, List<Integer>> makeGraph(List<List<Integer>> connections) {
            Map<Integer, List<Integer>> graph = new HashMap<>();

            for (List<Integer> connection : connections) {
                graph.computeIfAbsent(connection.get(0), k -> new ArrayList<Integer>()).add(connection.get(1));
                graph.computeIfAbsent(connection.get(1), k -> new ArrayList<Integer>()).add(connection.get(0));
            }

            return graph;
        }

        private void checkConnection(Map<Integer, List<Integer>> graphs, int start, List<Integer> nodes, int[] isVisited, List<Integer> removedEdge) {
            if (isVisited[start] == 0) {
                nodes.add(start);
            }

            isVisited[start] = 1;

            for (int next : graphs.get(start)) {
                if ((removedEdge.get(0) == start && removedEdge.get(1) == next) || (removedEdge.get(1) == start && removedEdge.get(0) == next) || isVisited[next] == 1) {
                    continue;
                }
                checkConnection(graphs, next, nodes, isVisited, removedEdge);
            }

        }
    }
}
