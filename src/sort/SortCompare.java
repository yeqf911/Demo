package sort;

/*************************************************************************
    > File Name: SortCompare.java
    > Author: yeqianfeng
    > Mail: yeqianfeng@gmail.com 
    > Created Time: Sun 17 May 2015 10:28:04 AM CST
 ************************************************************************/
public class SortCompare {
	public static double time(String alg, Comparable[] a) {
		StopWatch timer = new StopWatch();
		if(alg.equals("Insertion"))
			Insertion.sort(a);
		if(alg.equals("Selection"))
			Selection.sort(a);
		double time = timer.elapsedTime();
		return time;
	}

	public static double timeRandomInput(String alg,int N,int T) {
		Double[] a = new Double[N];
		double total = 0.0;
		for(int j = 0; j < T; j++){
			for(int i = 0; i < N; i++){
				a[i] = Math.random();
			}
			total += time(alg,a);
		}
		return total;		
	}

	public static void main(String[] args){
		String alg1 = args[0];
		String alg2 = args[1];

		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);

		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		
		System.out.println("time of " + alg1 + ": " + t1);
		System.out.println("time of " + alg2 + ": " + t2);
		System.out.println(alg1 + " / " + alg2 + ": " + (t1 / t2));
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
