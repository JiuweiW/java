package sort;
/**The {@code Insertion} class provides static methods for sorting an
 * array using insertion sort.
 *  This implementation makes ~ 1/2 n^2 compares and exchanges in
 *  the worst case, so it is not suitable for sorting large arbitrary arrays.
 *  More precisely, the number of exchanges is exactly equal to the number
 *  of inversions. So, for example, it sorts a partially-sorted array
 *  in linear time.
 */
public class Insertion {
	
	/**
	 * Compares two words a and b.
	 * @param a - the first word to be compared
	 * @param b - the second word to be compared
	 * @return {@code true} if word a has bigger score than b;
         *         {@code false} otherwise
	 */
	private static boolean higher(Word a, Word b) {
		if (a.getScore() > b.getScore())
			return true;
		return false;
	}
	/**
	 * Compares two comparable object a and b.
	 * @param a - the first comparable to be compared
	 * @param b - the second comparable to be compared
	 * @return {@code true} if comparable a has bigger score than b;
         *         {@code false} otherwise
	 */
	private static boolean higher(Comparable a, Comparable b) {
		if (((Word) a).getScore() >= ((Word) b).getScore())
			return true;
		return false;
	}
	
	/**
         * Exchange x[a] and x[b].
         * @param x - the input array containing times of words that need to be sorted.
         * @param a - the index of the first element for the array a to be exchanged.
         * @param b - the index of the second element for the array a to be exchanged.
         */
	private static void swap(Comparable[] x, int a, int b) {
		Comparable t = x[a];
		x[a] = x[b];
		x[b] = t;
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
	 * regular insertion sort
	 * @param x - the input array containing scores of words that need to be sorted.
	 */
	public static void sortInsert ( Word[] x) {
		int N = x.length;
		for (int i=0; i<N; i++) {
			for (int j=i; j>0 && higher(x[j], x[j-1]); j--) {
				// moved if inside the for to the condition of for, saved 30% of running time
				swap(x, j-1, j);
			}
		}
	}
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing scores of words that need to be sorted.
	 */
	public static void sortComparable ( Comparable[] x) {
		int N = x.length;
		for (int i=0; i<N; i++) {
			for (int j=i; j>0 && x[j].compareTo(x[j-1]) > 0; j--) {
//			for (int j=i; j>0 && higher(x[j], x[j-1]); j--) {
				// experimented with the two comparing method, turns out compareTo saves 1 ms in 4096 words
				// moved if inside the for to the condition of for, saved 30% of running time
				swap(x, j-1, j);
			}
		}
	}

	/**
	 * optimized insertion sort
	 * Sorting an array using an optimized binary insertion sort with half exchanges
	 * @param x - the input array containing scores of words that need to be sorted.
	 */
	public static void sortBinary ( Comparable[] x) {
		int N = x.length;
		for (int i=0; i<N; i++) {
			Comparable t = x[i];
			int left = 0;
			int right = i;
			while (left < right) {
				int middle = (left + right) / 2;
				if (t.compareTo(x[middle]) < 0)
					left = middle + 1;
				else
					right = middle;
			}
			for (int j=i; j>left; j--) {
				swap(x, j-1, j);
			}
		}
	}
    /**
     * Tests for insertion sort.
     *  @param args the command-line arguments
     */
    public static void main(String[] args){
        Comparable a[]=new Comparable[]{12,10,34,23,9,7,8,5,6};
        sortBinary(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
