package sort;

import java.util.Scanner;

/**
 * Created by yeqf on 5/17/15.
 *
 * 希尔排序可以看做是把数组分成h个子序列，然后对h个子序列进行排序
 * 随着h的值慢慢逼近值1，整个数组的的序列则越来越接近已经排好的序
 * 列，当h的值减小到1的时候，数组的序列已经接近排列好了，这样 h=1
 * 的时候实质上是做的插入排序，但是此时的数组做插入排序时间复杂度
 * 就大大降低了。(也可以看做是将数组分成h个列，然后对每列进行排序)
 * 例如：
 *		数组 {13 24 94 33 82 25 59 94 65 23 45 27 73 25 39 10 }
 *		h = 5的希尔排序可以看成这样：
 *		13  14  94  33  82
 *		25  59  94  65  23
 *		45  27  73  25  39
 *		10
 *		即看成5个竖列分别排序
 *		再将h = 3 就变成这样了：
 *		10  14  73
 *		25  23  13
 *		27  94  13
 *		39  25  59
 *		94  65  82
 *		45
 *		(该序列是h=5时已经排好序再分的)
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int h = 1;
        int N = a.length;
        while (h < N / 3) {
            h = N / 3;      //先找到不小于N/3的第一个h的位置
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {// 步进为h
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
