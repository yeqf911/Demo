package union_find;

import java.util.Scanner;

/**
 * Created by yeqf on 5/13/15.
 */
public class WeightQuickUnion {
    private int[] id;
    private int[] sr;
    private int count;

    public WeightQuickUnion(int N) {
        id = new int[N];
        sr = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sr[i] = 1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        WeightQuickUnion uf = new WeightQuickUnion(N);
		StopWatch timer = new StopWatch();
        while (in.hasNext()){
            int p = in.nextInt();
            int q = in.nextInt();
            if (uf.connect(p, q))
                continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println("count: " + uf.getCount());
		double time = timer.elapsedTime();
		System.out.println("time :" + time);
       // uf.displayId();
        System.out.println();

    }

    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq)
            return;
        if (sr[p] < sr[q]) {
            id[rootp] = rootq;
            sr[q] += sr[p];
        }
        else {
            id[rootq] = rootp;
            sr[p] += sr[q];
        }
        count--;
    }
/**
* optimized the QuickUnion
 **/
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    public boolean connect(int p, int q) {
        return find(p) == find(q);
    }

    public int getCount() {
        return count;
    }

    public void displayId() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(find(i)+" ");
        }
    }
}

class StopWatch{
    private final long start;

    public StopWatch(){
        start = System.currentTimeMillis();
    }

    public double elapsedTime(){
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
