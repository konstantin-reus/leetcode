package com.reus.leetcode;

/**
 * https://leetcode.com/problems/compare-version-numbers
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        String[] longer = ver1.length > ver2.length
                ? ver1
                : ver2;
        String[] shorter = longer == ver1
                ? ver2
                : ver1;

        for (int i = 0; i < longer.length; i++) {
            String shorterVerNumPlace = i > shorter.length - 1
                    ? "0"
                    : shorter[i];
            int compare = compare(longer[i], shorterVerNumPlace);
            if (compare != 0) {
                return longer == ver1
                        ? compare
                        : -compare;
            }
        }
        return 0;
    }

    private int compare(String longer, String shorter) {
        return Integer.valueOf(longer).compareTo(Integer.valueOf(shorter));
    }
}
