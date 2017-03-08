package sort;
/**The {@code Merge} class provides static methods for sorting an
 * array using merge sort.
 */
public class Merge {
	
	// the auxiliary array for merges
	private static Comparable[] aux;
	/**
	 * merge sort using Comparable array as input 
	 * @param x - the input array containing scores of words that need to be sorted.
	 */
	public static void sortMerge (Comparable[] x ) {
		// allocate space
		aux = new Comparable[x.length];
		sort(x, 0, x.length - 1);
	}
	/**
	 * Stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
	 * @param a - array for merge
	 * @param lo - the beginning index of array a for merge
	 * @param mid - the middling index of array a 
	 * @param hi - the ending index of array a for merge
	 */
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		// merge a[lo..mid] with a[mid+1..hi]
		int i = lo, j = mid+1;
		// copy to aux[]
		for (int k=lo; k<=hi; k++)
			aux[k] = a[k];
		// merge back to a[]
		for (int k=lo; k<=hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (higher(aux[j], aux[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}
	/**
	 * Compares two comparable a and b.
	 * @param a - the first comparable to be compared
	 * @param b - the second comparable to be compared
	 * @return {@code true} if comparable a bigger than b;
         *         {@code false} otherwise
	 */
	private static boolean higher(Comparable a, Comparable b) {
		return a.compareTo(b) > 0;
	}
	/**
	 * Merge sort a[lo..hi] using auxiliary array aux[lo..hi]
	 * @param a - the input array containing scores of words that need to be sorted.
	 * @param lo - the beginning index of array a for merge
	 * @param hi - the ending index of array a for merge
	 */
	private static void sort(Comparable[] a, int lo, int hi) {
		// sort a[lo..hi]
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo)/2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}
	
	/**
	 * Check if array is sorted - useful for debugging.
	 * @param x - the array for sort
         * @return {@code true} if array x is sorted;
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
         * Tests for merge sort
         * @param args the command-line arguments
         */
//    public static void main(String[] args){
//        Comparable a[]=new Comparable[]{12,10,34,23,9,7,8,5,6};
//        sortMerge(a);
//        for (int i=0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
//    }
}
