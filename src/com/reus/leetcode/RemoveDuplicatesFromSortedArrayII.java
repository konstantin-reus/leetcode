package com.reus.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 */
public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        int writePoint = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0 && nums[i - 1] > nums[i]) {
                return writePoint;
            }
            int cur = i;
            while (cur + 1 < nums.length && nums[cur + 1] == nums[i]) {
                cur++;
            }
            nums[writePoint] = nums[i];
            writePoint++;
            if (cur - i > 0) {
                nums[writePoint] = nums[i];
                writePoint++;
            }
            i = cur;
        }
        return writePoint;
    }
}
