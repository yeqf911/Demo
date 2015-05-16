package sort;

import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by yeqf on 5/16/15.
 */
public class Selection {
    public static void sort(Comparable[] a) {
        if (isSorted(a))
            return;
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (!less(a[min], a[j])) {
                    min = j;    //find the index of the minimum element
                }
            }
            exch(a,i,min);
        }
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i].toString() + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i],a[i-1]))
                return false;
        }
        return true;
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
        Selection.show(a);
        Selection.sort(a);
        System.out.println("----after sort----");
        Selection.show(a);
    }
}
