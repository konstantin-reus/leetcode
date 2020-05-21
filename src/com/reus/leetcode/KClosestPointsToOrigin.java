package com.reus.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.IntStream;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Queue<Integer[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
        for (int[] point : points) {
            queue.add(IntStream.of(point).boxed().toArray(Integer[]::new));
        }
        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            Integer[] poll = queue.poll();
            result[i] = new int[] {poll[0], poll[1]};
        }
        return result;
    }
}
