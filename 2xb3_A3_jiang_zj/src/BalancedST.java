import java.util.Arrays;

public class BalancedST {

    // precondition: a[] has no duplicates
    private static void perfect(BST bst, String[] a) {
        Arrays.sort(a);
        perfect(bst, a, 0, a.length - 1);
        StdOut.println();
    }

    // precondition: a[lo..hi] is sorted
    private static void perfect(BST bst, String[] a, int lo, int hi) {
        if (hi < lo) return;
        int mid = lo + (hi - lo) / 2;
        bst.put(a[mid], mid);
        StdOut.print(a[mid] + " ");
        perfect(bst, a, lo, mid-1);
        perfect(bst, a, mid+1, hi);
    }

    public static void main(String[] args) {
        String[] words = StdIn.readAllStrings();
        BST<String, Integer> bst = new BST<String, Integer>();
        perfect(bst, words);
    }
}


