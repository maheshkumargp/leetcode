package com.mahesh.sorting.searching;

public class FirstBadVersion {


    static boolean isBadVersion(int version) {
        return version == 4;
    }

    public static int firstBadVersion(int n) {
        return firstBadVersion(1, n);

    }

    private static int isBad(int i, int n) {
        if (i <= n) {
            int mid = i + n / 2;
            boolean goodVersion = false;
            boolean badVersion = isBadVersion(mid);
            if (mid > 0) {
                goodVersion = isBadVersion(mid - 1);
            }
            if (badVersion && !goodVersion) return mid;
            return badVersion ? isBad(i, mid - 1) : isBad(mid, n);
        }
        return n;
    }

    public static int firstBadVersion(int low, int high) {
        if (low >= high) return low;
        int x = (low + high) / 2;
        boolean curr = isBadVersion(x);
        if (curr) return firstBadVersion(low, x);
        return firstBadVersion(x + 1, high);
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

}
