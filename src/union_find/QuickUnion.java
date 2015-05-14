package union_find;

import java.util.Scanner;

/**
 * Created by yeqf on 5/13/15.
 */
public class QuickUnion {
    private int[] id;
    private int count;

    public QuickUnion(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        UnionFind uf = new UnionFind(N);
        while (in.hasNext()){
            int p = in.nextInt();
            int q = in.nextInt();
            if (uf.connect(p, q))
                continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
        }
        System.out.println("count: " + uf.getCount());
        uf.displayId();
        System.out.println();

    }

    public void union(int p, int q) {
        int rootp = find(p);
        int rootq = find(q);
        if (rootp == rootq)
            return;
        id[rootp] = rootq;
        count--;
    }
/**
 * 修改了find算法，找出每个触点所在的根触点
 * 所以在union操作中，会直接找出p，q的根触点
 * 进行union的时候实际上是把各自的根触点进行
 * 了合并，这样就优化了算法。
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
