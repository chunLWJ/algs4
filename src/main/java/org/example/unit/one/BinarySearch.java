package org.example.unit.one;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

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
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    public static int rank(int key,int[] a,int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid -1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi);
        else return mid;
    }
    public static int recursionRank(int key,int[] a) {
        return rank(key, a,0, a.length - 1);
    }


    public static void main(String[] args) {
        int[] whitelist = new In("/static/algs4-data/tinyT.txt").readAllInts();
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            // 建议 debug 调式一下
//            int rank = rank(key, whitelist);
            int rank = recursionRank(key,whitelist);
            StdOut.println(rank);
        }
    }
}
