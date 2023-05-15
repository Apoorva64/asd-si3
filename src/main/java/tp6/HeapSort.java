package tp6;
import td4.EmptyHeapException;

/**
 * A class for the heap sort algorithm.
 */
public class HeapSort {

	/**
	 * Sort the array in place using the heapsort algorithm
	 * Complexity: THETA( n.log(n) ) where n is the size of the array
	 */
	public static <T extends Comparable<T>> void sort(T[] array) {
		BinaryHeap<T> heap = new BinaryHeap<>(array);
		for(int i = 0; i < array.length; i++) {
			try {
				T j = heap.deleteExtreme();
				array[i] = j;
				System.out.println(array[i]);
			} catch (EmptyHeapException e) {
				e.printStackTrace();
			}
		}

	}
}
