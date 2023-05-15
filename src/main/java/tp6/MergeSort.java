package tp6;

/**
 * A class for the recursive merge sort algorithm.
 */
public class MergeSort {

	/**
	 * Sort the array using the recursive merge sort algorithm.
	 * This algorithm is not in place and needs an auxiliary array of
	 * the same size than the array to sort
	 * Complexity: THETA( n.log(n) ) where n is the size of the array
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<T>> void sort(T[] array) {
		T[] tmp = (T[]) new Comparable[array.length];
		sort(array,tmp,0,array.length - 1);
	}
	
	/**
	 * Sort the array in the range [lo, hi] using the portion [lo, hi]
	 * of the auxiliary array tmp
	 * Complexity: THETA( n.log(n) ) where n = hi - lo + 1
	 */
	private static <T extends Comparable<T>> void sort(T[] array, T[] tmp, int lo, int hi) {

	}
	
	/**
	 * Merge array[lo, mid] and array[mid+1, hi] into tmp[lo, hi]
	 * and copy back the result into array[lo, hi]
	 * Precondition: array[lo, mid] and array[mid+1, hi] are sorted
	 * Complexity: THETA( n ) where n = hi - lo + 1
	 */
	private static <T extends Comparable<T>> void merge(T[] array, T[] tmp, int lo, int mid, int hi) {

	}
	
	/**
	 * Copy the elements from tmp[lo, hi] into array[lo, hi]
	 * Complexity: THETA( n ) where n = hi - lo + 1
	 */
	private static <T> void transfer(T[] tmp, T[] array, int lo, int hi) {

	}
}
