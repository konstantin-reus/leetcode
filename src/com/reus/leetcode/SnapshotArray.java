package com.reus.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/snapshot-array
 */
public class SnapshotArray {
    private final Map<Integer, Map<Integer, Integer>> snapshot = new HashMap<>();
    private int curVer = 0;

    public SnapshotArray(int length) {

    }

    public void set(int index, int val) {
        snapshot.putIfAbsent(curVer, new HashMap<>());
        snapshot.get(curVer).put(index, val);
    }

    public int snap() {
        curVer++;
        return curVer - 1;
    }

    public int get(int index, int snap_id) {
        int c = snap_id;
        while (c >= 0) {
            Map<Integer, Integer> sn = snapshot.get(c);
            if (sn == null) {
                c--;
                continue;
            }
            Integer val = sn.get(index);
            if (val == null) {
                c--;
            } else {
                return val;
            }
        }
        return 0;
    }
}
