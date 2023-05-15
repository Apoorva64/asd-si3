package tp6;

/**
 * A class for simple sorting methods
 * We use the Comparable interface to compare elements
 * It's a utility class, so we don't need to instantiate it
 * @author Marc Gaetano
 * @author Mireille blay
 */
public class SimpleSorting {
	private SimpleSorting() {
	}

	/**
	 * Sort the array in place using the selection sort algorithm
	 */
	public static <T extends Comparable<T>> void selection(T[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j].compareTo(array[min]) < 0) {
					min = j;
				}
			}
			swap(array, i, min);
		}

	}
	
	/**
	 * Sort the array in place using the insertion sort algorithm
	 */
	public static <T extends Comparable<T>> void insertion(T[] array) {
		for (int i = 1; i < array.length; i++) {
			T tmp = array[i];
			int j = i;
			while (j > 0 && tmp.compareTo(array[j - 1]) < 0) {
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
