package tp6;

/**
 * A class for the quicksort algorithm
 */
public class QuickSort {
	
	private static final int CUTOFF = 10;
	
	/**
	 * Sort the array in place using the quicksort algorithm
	 */
	public static <T extends Comparable<T>> void sort(T[] array) {
		sort(array,0,array.length-1);
	}

	/**
	 * Sort the portion array[lo,hi] in place using the quicksort algorithm
	 */	
	private static <T extends Comparable<T>> void sort(T[] array, int lo, int hi) {
		if (hi - lo < CUTOFF) {
			insertion(array, lo, hi);
		} else {
			int pivot = partition(array, lo, hi);
			sort(array, lo, pivot - 1);
			sort(array, pivot + 1, hi);
		}


	}

	/**
	 * Partition the portion array[lo,hi] and return the index of the pivot
	 */
	private static <T extends Comparable<T>> int partition(T[] array, int lo, int hi) {
		int mid = (lo + hi) / 2;
		int pivot = median(array, lo, mid, hi);
		swap(array, pivot, hi);
		int i = lo;
		int j = hi - 1;
		while (i <= j) {
			while (array[i].compareTo(array[hi]) < 0) {
				i++;
			}
			while (j >= lo && array[j].compareTo(array[hi]) > 0) {
				j--;
			}
			if (i < j) {
				swap(array, i, j);
				i++;
				j--;
			}
		}
		swap(array, i, hi);
		return i;
	}

	/**
	 * Return the index of the median of { array[lo], array[mid], array[hi] }
	 */
	private static <T extends Comparable<T>> int median(T[] array, int lo, int mid, int hi) {
		if (array[lo].compareTo(array[mid]) < 0) {
			if (array[mid].compareTo(array[hi]) < 0) {
				return mid;
			} else if (array[lo].compareTo(array[hi]) < 0) {
				return hi;
			} else {
				return lo;
			}
		} else {
			if (array[lo].compareTo(array[hi]) < 0) {
				return lo;
			} else if (array[mid].compareTo(array[hi]) < 0) {
				return hi;
			} else {
				return mid;
			}
		}
	}
	
	/**
	 * Sort array[lo, hi] in place using the insertion sort algorithm
	 */
	private static <T extends Comparable<T>> void insertion(T[] array, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			T tmp = array[i];
			int j = i;
			while (j > lo && tmp.compareTo(array[j - 1]) < 0) {
				array[j] = array[j - 1];
				j--;
			}
			array[j] = tmp;
		}

	}
	
	/**
	 * Swap array[i] and array[j]
	 */
	private static <T> void swap(T[] array, int i, int j) {
		T tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
