package org.example.unit.one;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

public class ThreeSumFast {

    public static int count(int[] a ){
        Arrays.sort(a);
        int cnt = 0;
        int N = a.length;
        for (int i=0; i<N; i++)
            for (int j=i+1; j<N; j++)
                if (BinarySearch.rank(-a[i]-a[j],a) > j)
                    cnt++;
        return cnt;
    }

    public static void main(String[] args) {
//        int[] a = new In("/static/algs4-data/1Kints.txt").readAllInts();
//        int[] a = new In("/static/algs4-data/2Kints.txt").readAllInts();
//        int[] a = new In("/static/algs4-data/4Kints.txt").readAllInts();
        int[] a = new In("/static/algs4-data/1Mints.txt").readAllInts(); // 一百万 的 N^2 * LogN 是需要很长时间的


        // 暴力算法，三次循环
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        double time = timer.elapsedTime();
        StdOut.println(count + " triples " + time + " seconds");
    }
}
