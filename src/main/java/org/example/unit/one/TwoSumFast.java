package org.example.unit.one;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class TwoSumFast {

    /**
     * 计算 a+b = 0 的个数
     * @param a 数组
     * @return a+b = 0 个数
     */
    public static int count(int[] a) {
        Arrays.sort(a);
        int N = a.length;
        int cnt = 0;
        for (int i=0; i<N; i++) {
            if (BinarySearch.rank(-a[i],a) > i)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
//        int[] a = new In("/static/algs4-data/1Kints.txt").readAllInts();
//        int[] a = new In("/static/algs4-data/2Kints.txt").readAllInts();
//        int[] a = new In("/static/algs4-data/4Kints.txt").readAllInts();
//        int[] a = new In("/static/algs4-data/1Mints.txt").readAllInts(); // 一百万 的 NLogN 一会即可
//        int[] a = new In("/static/algs4-data/largeDG.txt").readAllInts(); // 一千万 的 NlogN 1.75秒...
        int[] a = new In("/static/algs4-data/largeG.txt").readAllInts(); // 一千五百万 的 NlogN 1.75秒...
//        int[] a = new In("/static/algs4-data/largeT.txt").readAllInts(); // 一千万 的 NlogN 1.225
        // 暴力算法，三次循环
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        double time = timer.elapsedTime();
        StdOut.println(count + " triples " + time + " seconds");

    }
}
