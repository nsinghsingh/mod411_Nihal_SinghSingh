package Sorts;

public class AB411_07_BubbleSort<T extends Comparable<T>> implements Sort<T> {

    public void sort(T[] array) {
        for (int n = array.length; n > 1; --n) {
            for (int i = 0; i < n - 1; ++i) {
                if (array[i].compareTo(array[i + 1]) > 0) {
                    T a = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = a;
                }
            }
        }
    }
}
