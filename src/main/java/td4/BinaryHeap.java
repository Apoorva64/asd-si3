package td4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Logger;

/**
 * array class for binary heap implementation
 */
public class BinaryHeap<T extends Comparable<? super T>> {

    public static final Logger LOGGER = Logger.getLogger(BinaryHeap.class.getName());
    private T[] array; // to store the heap
    private int size;    // the number of elements in the heap

    // comparator to choose
    private Comparator<T> comparator = Comparable::compareTo;

    /**
     * Return the array of the heap.
     * This method is only for testing purposes.
     *
     * @return the array of the heap
     */
    protected T[] getArray() {
        return array;
    }

    ///////////// Constructors

    /**
     * Build a heap of capacity n.
     * The elements are ordered according to the
     * natural order on T.
     * The heap is empty.
     * Complexity: THETA(1)
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap(int n) {
        array = (T[]) new Comparable[n];
        size = 0;
    }

    /**
     * Build a heap of capacity n.
     * The elements are ordered according to comparator.
     * The heap is empty.
     * Complexity: THETA(1)
     */
    @SuppressWarnings("unchecked")
    public BinaryHeap(int n, Comparator<T> comparator) {
        this.array = (T[]) new Comparable[n];
        this.size = 0;
        this.comparator = comparator;
    }

    /**
     * Build a heap based on array array.
     * The elements are ordered according to the
     * natural order on T.
     * The heap is full
     */
    public BinaryHeap(T[] a) {
        this.array = a;
        this.size = a.length;
        buildHeap();
    }

    /**
     * Build a heap based on array array.
     * The elements are ordered according to comparator.
     * The heap is full
     */
    public BinaryHeap(T[] array, Comparator<T> comparator) {
        this.array = array;
        this.size = array.length;
        this.comparator = comparator;
        buildHeap();
    }

    ///////////// Private methods

    /**
     * Swap values in the array
     * at indexes i and j.
     * Complexity: THETA(1)
     */
    private void swap(int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     * Return the number of the left
     * node of node number n.
     * Complexity: THETA(1)
     */
    private int left(int n) {
        return 2 * n + 1;
    }

    /**
     * Return the number of the right
     * node of node number n.
     * Complexity: THETA(1)
     */
    private int right(int n) {
        return 2 * (n + 1);
    }

    /**
     * Return the number of the parent
     * node of node number n.
     * Complexity: THETA(1)
     */
    private int parent(int n) {
        return (n - 1) / 2;
    }

    /**
     * Percolate down the element at node number n
     * Complexity: O(log(size))
     */
    private void percolateDown(int n) {
        if(isLeaf(n)) {
            return;
        }
        int left = left(n);
        int right = right(n);
        int min = left;
        if (right < size && comparator.compare(array[right], array[left]) < 0) {
            min = right;
        }
        if (comparator.compare(array[n], array[min]) > 0) {
            swap(n, min);
            percolateDown(min);
        }
    }

    /**
     * Percolate up the element at node number n
     * Complexity: O(log(size))
     */
    private void percolateUp(int n) {
        int parent = parent(n);
        if (parent >= 0 && comparator.compare(array[n], array[parent]) < 0) {
            swap(n, parent);
            percolateUp(parent);
        }

    }

    /**
     * Arrange the elements in array such
     * that it has the heap property.
     * Complexity: O(size)
     */
    private void buildHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }


    }

    ///////////// Public methods

    /**
     * Return the size of the heap
     * (the number of elements in the heap).
     * Complexity: THETA(1)
     */
    public int size() {
        return size;
    }

    /**
     * Check if the heap is empty.
     * Complexity: THETA(1)
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return the extreme element.
     * Complexity: THETA(1)
     */
    public T extreme() throws EmptyHeapException {
        if (isEmpty()) {
            throw new EmptyHeapException();
        }
        return Arrays.stream(array).sorted().findFirst().orElseThrow();
    }

    /**
     * Return and delete the extreme element.
     * Ensure that the free space is at the end of the array and does not refer to any element.
     * Complexity: O(log(size))
     */
    public T deleteExtreme() throws EmptyHeapException {
        if (isEmpty()) {
            throw new EmptyHeapException();
        }
        T extreme = array[0];
        array[0] = array[size - 1];
        array[size - 1] = null;
        size--;
        percolateDown(0);
        return extreme;
    }

    /**
     * Add a new element in the heap
     * Complexity: O(log(size))
     */
    public void add(T e) throws FullHeapException {
        if (size == array.length) {
            throw new FullHeapException();
        }
        array[size] = e;
        size++;
        percolateUp(size - 1);

    }

    ///////////// Part 3: deleting in the heap

    /**
     * Delete the element e from the heap.
     * Complexity: O(size)
     */
    public void delete(T e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(array[i])) {
                array[i] = array[size - 1];
                array[size - 1] = null;
                size--;
                percolateDown(i);
                break;
            }
        }

    }

    /**
     * Delete all the elements e from the heap.
     * Complexity: O(size)
     */
    public void deleteAll(T e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(array[i])) {
                array[i] = array[size - 1];
                array[size - 1] = null;
                size--;
                percolateDown(i);
                i--;
            }
        }

    }

    public String byLevels() {
        StringBuilder bld = new StringBuilder();
        int level = 0;
        int nbNodes = 1;
        for (int i = 0; i < size; i++) {
            if (i == nbNodes) {
                bld.append("\n");
                level++;
                nbNodes += Math.pow(2, level);
            }
            bld.append("(" + i + ")" + array[i] + " ");
        }
        return bld.toString();
    }

    public boolean isLeaf(T t) {
        // find index of t in  array.
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (t.equals(array[i])) {
                index = i;
                break;
            }
        }
        return isLeaf(index);
    }

    public boolean isLeaf(int index) {
        return index > size / 2;
    }

    public String toStringByLevels() {
        return null;    // TODO
    }

    public T inverseExtreme() {
        return null;    // TODO
    }
}
