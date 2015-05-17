package sort;

import java.util.Scanner;

/**
 * Created by yeqf on 5/17/15.
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int h = 1;
        int N = a.length;
        while (h < N / 3) {
            h = N / 3;
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1]))
                return false;
        }
        return true;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer[] a;
        int N = in.nextInt();
        a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Integer(in.nextInt());
        }
        System.out.println("----before sort----");
        Shell.show(a);
        Shell.sort(a);
        System.out.println("----after sort----");
        Shell.show(a);
    }
}
