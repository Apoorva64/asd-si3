package tp6;

class MergeSortTest extends AbstractSortTest{

    @Override
    protected <T extends Comparable> void sort(T[] array) {
        MergeSort.sort(array);
    }

}
