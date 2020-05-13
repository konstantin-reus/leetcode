package com.reus.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoomsTwo {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (interval1, interval2) -> interval1[0] < interval2[0] ? -1 : 1);
        Queue<Integer> endsMin = new PriorityQueue<>();
        int rooms = 0;
        for (int[] i : intervals) {
            endsMin.add(i[1]);
            if (i[0] < endsMin.peek()) {
                rooms++;
            } else {
                endsMin.poll();
            }
        }
        return rooms;
    }
}
