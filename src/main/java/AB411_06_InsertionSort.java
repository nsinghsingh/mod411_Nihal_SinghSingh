public class AB411_06_InsertionSort<T extends Comparable<T>> {

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

    public static void main(String[] args) {
        Integer[] liste = {0, 4, 9, 6, 2, 8, 5, 1, 7, 3};
        AB411_06_InsertionSort<Integer> integerSort = new AB411_06_InsertionSort<>();
        integerSort.sort(liste);
        for (int value : liste) System.out.print(value + " ");
    }
}
