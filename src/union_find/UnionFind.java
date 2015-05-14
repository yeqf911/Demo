package union_find;

import java.util.Scanner;

/**
 * Created by yeqf on 5/13/15.
 */
public class UnionFind {
    private int[] id;
    private int count;

    public UnionFind(int N) {
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
        int pId = find(p);
        int qId = find(q);
        if (pId == qId)
            return;
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId)
                id[i] = qId;
        }
        count--;
    }

    public int find(int p) {
        return id[p];
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
