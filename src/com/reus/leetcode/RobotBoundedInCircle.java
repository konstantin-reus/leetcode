package com.reus.leetcode;

/**
 * https://leetcode.com/problems/robot-bounded-in-circle
 */
public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        int y = 0;
        int x = 0;
        int vector = 0; // 0 - north, 1 - east, 2 - south, 3 - west
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                vector = vector == 0
                        ? 3
                        : vector - 1;
            } else if (c == 'R') {
                vector = vector == 3
                        ? 0
                        : vector + 1;
            } else if (c == 'G') {
                switch(vector) {
                    case 0: {
                        y++;
                        break;
                    }
                    case 1: {
                        x++;
                        break;
                    }
                    case 2: {
                        y--;
                        break;
                    }
                    case 3: {
                        x--;
                        break;
                    }
                }
            }
        }
        return y == 0 && x == 0 || vector != 0;
    }
}
