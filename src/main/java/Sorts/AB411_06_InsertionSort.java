package Sorts;

public class AB411_06_InsertionSort<T extends Comparable<T>> implements Sort<T> {

    public void sort(T[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            T value = numbers[i];
            int j = i;
            while ((j > 0) && (numbers[j - 1].compareTo(value) > 0)) {
                numbers[j] = numbers[j - 1];
                j = j - 1;
                numbers[j] = value;
            }
        }
    }
}
