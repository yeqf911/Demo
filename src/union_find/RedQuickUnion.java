import java.util.Scanner;

/**
 * Created by yeqf on 5/13/15.
 */
public class RedQuickUnion {
    private int[] id;
    private int count;
    private int num;

    public RedQuickUnion(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        RedQuickUnion uf = new RedQuickUnion(N);
        while (in.hasNext()) {
            int p = in.nextInt();
            int q = in.nextInt();
			//if(p == 655302)
			//	System.exit(0);
            if (uf.connect(p, q))
                continue;
            uf.union(p, q);
            System.out.println(p + " " + q);
           // uf.displayId();
            //System.out.println(uf.getNum());
        }
        System.out.println("count: " + uf.getCount());
        System.out.println();
    }

    public void union(int p, int q) {
        int rootp = find(p);
		int rootq = find(q);
        if (rootp == rootq)
            return;
		id[rootq] = rootp;
       // num++;
        count--;
    }

    public int find(int p) {
		int root = p;
        while (root != id[root]) {
            root = id[root];
       //     num += 2;
        }
		while (p != root){
			int n = id[p];
			id[p] = root;
			p = n;
		}
        return root;
    }

    public boolean connect(int p, int q) {
        return find(p) == find(q);
    }

    public int getCount() {
        return count;
    }

    public int getNum() {
        return num;
    }

    public void displayId() {
        for (int i = 0; i < id.length; i++) {
            System.out.print(find(i) + " ");
        }
        System.out.println();
    }
}

class StopWatch {
    private final long start;

    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
