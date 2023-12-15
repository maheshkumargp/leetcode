package com.mahesh.sorting.searching;

public class FirstBadVersion {


    static boolean isBadVersion(int version) {
        return version == 4 ? true : false;
    }

    public static int firstBadVersion(int n) {
        return isBad(1, n);

    }

    private static int isBad(int i, int n) {
        if (i <= n) {
            int mid = i + n / 2;
            boolean goodVersion = false;
            boolean badVersion = isBadVersion(mid);
            if (mid > 0) {
                goodVersion = isBadVersion(mid - 1);
            }
            if (badVersion == true && goodVersion == false) return mid;
            return badVersion == true ? isBad(i, mid - 1) : isBad(mid, n);
        }
        return n;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(5));
    }

}
