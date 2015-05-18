package sort;

import java.util.Scanner;

/**
 * Created by yeqf on 5/18/15.
 */
public class Merge {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
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

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        int l = lo;
        int h = mid+1;

        for (int i = l; i <= hi; i++) {
            aux[i] = a[i];
        }

        for (int k = lo; k <= hi; k++) {
            if (l > mid) {
                a[k] = aux[h];
                h++;
            } else if (h > hi) {
                a[k] = aux[l];
                l++;
            } else if (less(aux[l], aux[h])) {
                a[k] = aux[l];
                l++;
            } else {
                a[k] = aux[h];
                h++;
            }
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

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
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
       /* int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for(int i = 0; i < N; i++){
            a[i] = Math.random();
        }*/
        System.out.println("----before sort----");
        Merge.show(a);
        Merge.sort(a);
        System.out.println("----after sort----");
        Merge.show(a);
    }

}
