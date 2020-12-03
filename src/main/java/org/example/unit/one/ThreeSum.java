package org.example.unit.one;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class ThreeSum {
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i=0; i<N; i++)
            for (int j=i+1; j<N; j++)
                for (int k=j+1; k<N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;

        return cnt;
    }

    public static void main(String[] args) {
//        int[] a = new In("/static/algs4-data/1Kints.txt").readAllInts();
//        int[] a = new In("/static/algs4-data/2Kints.txt").readAllInts();
        int[] a = new In("/static/algs4-data/4Kints.txt").readAllInts();


        // 暴力算法，三次循环
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        double time = timer.elapsedTime();
        StdOut.println(count + " triples " + time + " seconds");
    }
}
