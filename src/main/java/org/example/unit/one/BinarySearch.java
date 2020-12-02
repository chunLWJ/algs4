package org.example.unit.one;

public class BinarySearch {

    /**
     * 二分查找算法
     * @param key 查找的 键
     * @param a 有序的数组
     * @return index || -1
     */
    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
