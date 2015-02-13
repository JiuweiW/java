package sort;

public class Heap {
	/**
	 * heap sort using Comparable
	 * @param x - the input array containing scores of words that need to be sorted.
	 */
	public static void sortHeap ( Comparable[] x) {
		int N = x.length;
		for (int k=N/2; k>=1; k--)
			sink(x, k, N);
		while (N > 1) {
			swap(x, 1, N--);
			sink(x, 1, N);
		}
	}
	
	private static void sink(Comparable[] x, int k, int N) {
		while (2*k <= N) {
			int j = 2*k;
			if (j < N && higher(x, j, j+1))
				j++;
			if (!higher(x, k, j))
				break;
			swap(x, k, j);
			k = j;
		}
	}
	
	private static boolean higher (Comparable[] x, int i, int j) {
		return x[i-1].compareTo(x[j-1]) > 0;
	}
	
	private static boolean higher (Comparable a, Comparable b) {
		return (a.compareTo(b) > 0);
	}
	
	private static void swap(Comparable[] x, int i, int j) {
		Comparable t = x[i-1];
		x[i-1] = x[j-1];
		x[j-1] = t;
	}
	
	// check if the array is sorted
	public static boolean isSorted(Word[] x) {
		for (int i=0; i<x.length-1; i++) {
			if ((x[i].compareTo(x[i+1]) < 0))
				return false;
		}
		return true;
	}
	
//    public static void main(String[] args){
//        Comparable a[]=new Comparable[]{12,10,34,23,9,7,8,5,6};
//        sortHeap(a);
//        for (int i=0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
//    }
}
