package com.reus.leetcode;

import java.util.Arrays;

public class MergeSortedArrays {
    public static void main(String[] args) {
        MergeSortedArrays m = new MergeSortedArrays();
        int[] l = new int[]{1, 2, 3, 0, 0, 0};
        int[] r = new int[]{2, 5, 6};
        m.merge(l, 6, r, 3);
        System.out.println(Arrays.toString(l));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int r = 0;
        int l = 0;

        for (int i = 0; i < n; i++) {

            while (l < nums1.length && nums1[l] < nums2[r]) {
                l++;
            }
            shiftRight(nums1, l);
            nums1[l] = nums2[r++];
        }
    }

    private void shiftRight(int[] arr, int start) {
        for (int i = arr.length - 1; i > start; i--) {
            arr[i] = arr[i - 1];
        }
    }
}
