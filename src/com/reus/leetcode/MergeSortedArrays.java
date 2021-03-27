package com.reus.leetcode;

/**
 * https://leetcode.com/problems/merge-sorted-array
 */
public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = nums1[i];
        }
        int writeIndex = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = 0; i < m + n; i++) {
            Integer toAdd = null;
            if (p1 >= 0 && p2 >= 0) {
                toAdd = Math.max(nums2[p2], nums1[p1]);
                if (nums2[p2] > nums1[p1]) {
                    p2--;
                } else {
                    p1--;
                }
            } else if (p1 >= 0 && p2 < 0) {
                toAdd = nums1[p1--];
            } else if (p2 >= 0 && p1 < 0) {
                toAdd = nums2[p2--];
            }
            nums1[writeIndex--] = toAdd;
        }
    }
}
