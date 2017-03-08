package sort;
/**The {@code Heap} class provides a static methods for heap sort
 */
public class Heap {
	/**
	 * Heap sort using comparable object.
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
	/**
	 * Helper functions to restore the heap invariant.
	 * @param x - the input array containing times of words that need to be sorted.
	 * @param k - the index of element needs to be sinked.
	 * @param n - the size of the input array
	 */
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
	/**
	 * Compares two comparable x[i-1] and x[j-1].
	 * @param x - the array for compared.
	 * @param i - the index of first comparable to be compared
	 * @param j - the index of second comparable to be compared
	 * @return {@code true} if comparable a[i-1] bigger than a[j-1];
         *         {@code false} otherwise
	 */
	private static boolean higher (Comparable[] x, int i, int j) {
		return x[i-1].compareTo(x[j-1]) > 0;
	}
	/**
	 * Compares two comparable a and b.
	 * @param a - the first comparable to be compared
	 * @param b - the second comparable to be compared
	 * @return {@code true} if comparable a bigger than b;
         *         {@code false} otherwise
	 */
	private static boolean higher (Comparable a, Comparable b) {
		return (a.compareTo(b) > 0);
	}
	/**
         * Exchange x[i-1] and x[j-1]
         * @param x - the input array containing times of words that need to be sorted.
         * @param i - the index of the first element for the array a to be exchanged.
         * @param j - the index of the second element for the array a to be exchanged.
         */
	private static void swap(Comparable[] x, int i, int j) {
		Comparable t = x[i-1];
		x[i-1] = x[j-1];
		x[j-1] = t;
	}
	
	/**
	 * Check if array is sorted - useful for debugging.
	 * @param x - the array for sort
	 * @return {@code true} if array a is sorted;
         *         {@code false} otherwise
	 */
	public static boolean isSorted(Word[] x) {
		for (int i=0; i<x.length-1; i++) {
			if ((x[i].compareTo(x[i+1]) < 0))
				return false;
		}
		return true;
	}
	/**
	 * Tests for heap sort
	 * @param args the command-line arguments
	 */
//    public static void main(String[] args){
//        Comparable a[]=new Comparable[]{12,10,34,23,9,7,8,5,6};
//        sortHeap(a);
//        for (int i=0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
//    }
}
