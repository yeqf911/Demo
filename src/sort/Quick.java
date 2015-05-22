package sort;

import java.util.Scanner;

/**
 * Created by yeqf on 5/21/15.
 */
public class Quick {
    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int p, int r) {
        if (r <= p)
            return;
        int q = partition(a, p, r);
        sort(a, p, q - 1);
        sort(a, q + 1, r);
    }

    public static int partition(Comparable[] a, int p, int r) {
        Comparable temp = a[r];
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (less(a[j], temp)) {
                i++;
                exch(a, j, i);
                /*StdDraw.clear(StdDraw.WHITE);
                for (int k = 0; k < a.length; k++) {
                    double x = 1.0 * k / a.length;
                    double y = (double)a[k] / 2.0;
                    double rw = 0.5 / a.length;
                    double rh = (double)a[k] / 2.0;
                    StdDraw.filledRectangle(x, y, rw, rh);
                }
                StdDraw.show(100);*/
            }
        }
        exch(a, i + 1, r);
        return i + 1;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
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
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i].toString() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
     /*   int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = Math.random();
        }*/
        Scanner in = new Scanner(System.in);
        Integer[] a;
        int N = in.nextInt();
        a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = new Integer(in.nextInt());
        }
        System.out.println("----before sort----");
        Quick.show(a);
        Quick.sort(a);
        System.out.println("----after sort----");
        Quick.show(a);
    }
}
