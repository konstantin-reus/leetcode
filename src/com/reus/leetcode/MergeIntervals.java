package com.reus.leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/submissions/
 * <p>
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an
 * array of the non-overlapping intervals that cover all the intervals in the input.
 * <p>
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] == i2[0] ? i1[1] - i2[1]
                : i1[0] - i2[0]);
        List<Interval> tmp = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int j = i;
            int curEnd = intervals[i][1];
            while (j < intervals.length && intervals[j][0] <= intervals[i][1]) {
                curEnd = Math.max(curEnd, intervals[j][1]);
                j++;
            }
            if (--j > i) {
                tmp.add(new Interval(intervals[i][0], Math.max(intervals[j][1], curEnd)));
                i = j;
            } else {
                tmp.add(new Interval(intervals[i][0], intervals[i][1]));
            }
            checkIntersectionLastTwo(tmp);
        }
        int[][] result = new int[tmp.size()][2];
        for (int i = 0; i < tmp.size(); i++) {
            result[i][0] = tmp.get(i).start;
            result[i][1] = tmp.get(i).end;
        }
        return result;
    }

    private void checkIntersectionLastTwo(List<Interval> intervals) {
        if (intervals.size() < 2) {
            return;
        }
        Interval last = intervals.get(intervals.size() - 1);
        Interval beforeLast = intervals.get(intervals.size() - 2);
        if (last.start <= beforeLast.end) {
            intervals.remove(intervals.size() - 1);
            intervals.remove(intervals.size() - 1);
            intervals.add(new Interval(beforeLast.start, Math.max(last.end, beforeLast.end)));
        }
    }


    private static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return String.format("start=%d, end=%d", start, end);
        }
    }
}
