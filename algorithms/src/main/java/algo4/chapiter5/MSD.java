//package algo4.chapiter5;
//
//import edu.princeton.cs.algs4.Insertion;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by lsy on 2016/4/19.
// */
//public class MSD {
//    private static int R = 256;
//    private static final int M = 15;
//    private static String[] aux;
//
//    private static int charAt(String s, int d) {
//        return d < s.length() ? s.charAt(d) : -1;
//    }
//
//    public static void sort(String[] a) {
//        int N = a.length;
//        aux = new String[N];
//    }
//
//    private static void sort(String[] a, int lo, int hi, int d) {
//        if (hi <= lo + M) {
//            Insertion.sort(a, lo, hi, d);
//            return;
//        }
//        int[] count = new int[R + 2];
//        for (int i = lo; i <= hi; i++) {
//            count[charAt(a[i], d) + 2]++;
//        }
//        for (int r = 0; r < R + 1; r++) {
//            count[r + 1] += count[r];
//        }
//        for (int i = lo; i <= hi; i++) {
//            aux[count[charAt(a[i], d) + 1]++] = a[i];
//        }
//        for (int i = lo; i <= hi; i++) {
//            a[i] = aux[i - lo];
//        }
//        for (int r = 0; r < R; r++) {
//            sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1+);
//        }
//    }
//}
